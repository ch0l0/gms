package com.leo.gms.data

class LoginUserBO implements Serializable {
    static final long serialVersionUID = 1L
    int loginUserId
    String activeSessionId
    String loginName
    String encryptedPwd
    Date passwordExpiry
    Date lastActionDateTime
    Date lastAuthCheck
    Date loginDateTime
    String loginIP
    String loginCountry
    int auditUserId
    String auditUserName



    Locale locale

    boolean isPwdExpired(){
        if (!passwordExpiry)
            return true
        else {
            return (new Date()).after(passwordExpiry)
        }
    }

}
