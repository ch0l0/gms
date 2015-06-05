package com.leo.gms.ctrl

import grails.converters.JSON
import org.springframework.web.servlet.support.RequestContextUtils as RCU

abstract class BaseController {

    def messageSource

    def renderJsonResult(def rslt){
        response.characterEncoding = 'UTF-8'
        if (!rslt.success && rslt.errorCode){
            Locale locale = RCU.getLocale(request)
            String translatedMsg = messageSource.getMessage("error.code.$rslt.errorCode",rslt.errorArgs, rslt.errorMessage,locale)
            rslt.errorMessage =  translatedMsg?translatedMsg:rslt.errorCode
        }
        JSON.use("customJSON")
        render rslt as JSON
    }
}
