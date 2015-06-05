package com.leo.gms.service.common

import com.leo.gms.exception.BLResponseException


class AuthService extends BaseService{

    def login(String loginName, String password, String loginIP, String loginCountry, String sessionId) {


        try{
            //def loginUser=Profile.findByLoginName(loginName)

            def loginUser = [loginName:loginName]

            def retObj =[
                    loginName: loginUser.loginName
            ]
            return getSuccessResp([sessionObj:loginUser,respObj:retObj])
        } catch (BLResponseException e){
            return getErrorResp(e.errorList[0])
        }

    }
}
