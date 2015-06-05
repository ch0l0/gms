package com.leo.gms.ctrl

import com.leo.gms.util.CommonUtil


class LoginController extends BaseController{

    def authService

    def showLogin = {
        render view: '/index'
    }


    def auth = {
        log.debug params
        def loginIP      = CommonUtil.getClientIPFromRequest(request)
        def loginCountry = CommonUtil.getClientCountryCodeFromRequest(request)

        def resp = authService.login(params.loginName,params.password,loginIP,loginCountry,session.getId())
        if (resp.success && resp.result && resp.result.sessionObj && resp.result.respObj){
            session.user = resp.result.sessionObj
            redirect(mapping:'homePage')
        } else {
            render (view: '/index',model:[result:resp])
        }

    }



    def logout={
        log.debug("*****************************logout")
        if (session.user){
            //authService.logout(session.user.loginName,session.getId(),session.user.loginSource)
            session.user = null
        }
        //renderJsonResult(authService.getSuccessResp())
        redirect(mapping:'loginPage')
    }
}
