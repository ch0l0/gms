package com.leo.gms.ctrl

class HomeController {

    def index = {
        log.debug("***** Home index")
        if (!session.user)
            redirect(mapping:'loginPage')


        [loginName: session.user?.loginName]
    }
}
