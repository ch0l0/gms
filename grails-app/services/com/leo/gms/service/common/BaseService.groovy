package com.leo.gms.service.common


import com.leo.gms.data.ErrorMessage


class BaseService {

    int defaultPageSize =10


    def getErrorResp(ErrorMessage errorMsg){
        return [success: false, errorCode:errorMsg.errorCode, errorMessage:errorMsg.errorMessage, errorArgs: errorMsg.args ]
    }

    def getGenericErrorResp(){
        return [success: false, errorCode: "AG9001", errorMessage: "Failed to perform task. Pls try again."]
    }

    def getSuccessResp(def result="success"){
        return [success: true , result:result]
    }

   /* def insertAudit(Class <? extends IAuditDataConverter> converterClass,
                    LoginUserBO loginUser, AuditPairBO auditPair,
                    Object... args){
        auditBLService.insertAuditToQueue(converterClass, loginUser, auditPair, args)
    }*/

    def getPageSize(){
        return defaultPageSize
    }

    def getPageOffset(def currPage){
        def pageOffset = currPage?:0
        if (pageOffset > 0)
            pageOffset = (pageOffset - 1) * getPageSize()

        return pageOffset
    }

    def getPagingList(def list, def currPage){
        def offset = getPageOffset(currPage)
        def pagingList = []
        if (!list.isEmpty()) {
            def endRec = offset + getPageSize()
            if (endRec > list.size())
                endRec = offset  + (list.size() % getPageSize())
            pagingList = list.subList(offset,endRec)
        }
        return pagingList
    }
}
