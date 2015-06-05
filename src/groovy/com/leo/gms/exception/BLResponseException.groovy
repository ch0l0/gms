package com.leo.gms.exception

import com.leo.gms.data.BLResponse
import com.leo.gms.data.ErrorMessage


class BLResponseException extends Exception{
    static final long serialVersionUID = 1L

    BLResponse response

    BLResponseException() {
        super()
    }

    BLResponseException(BLResponse response) {
        super()
        this.response = response
    }

    @Override
    String getMessage() {
        String ret = ""
        response.errorList.each{ err ->
            if (ret.isEmpty())
                ret = err.errorMessage
            else
                ret = ret + "\r\n" + err.errorMessage
        }
        return ret
    }

    List<ErrorMessage> getErrorList() {
        return response.errorList?response.errorList:[]
    }

    ErrorMessage getFirstErrorMessage(){
        return response.errorList?response.errorList.get(0):null
    }
}
