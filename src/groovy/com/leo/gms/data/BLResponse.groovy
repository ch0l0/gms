package com.leo.gms.data

class BLResponse implements Serializable {
    static final long serialVersionUID = 1L

    List<ErrorMessage> errorList = []
    Serializable reference
    AuditPairBO auditPairBO

    Map<String, ErrorMessage> getErrorMap() {
        Map<String, ErrorMessage> errorMap = [:]
        errorList.each{
            errorMap[it.key] = it
        }
        return errorMap
    }

    def addErrorMessage(ErrorMessage errorMessage) {
        if (errorMessage){
            errorList.add(errorMessage)
        }
    }

    def addErrorMessageList(List <ErrorMessage> errorMessages) {
        if (errorMessages){
            errorList.addAll(errorMessages)
        }
    }

    boolean isSuccess() {
        return !errorList
    }
}
