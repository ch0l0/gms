package com.leo.gms.data

class ErrorMessage implements Serializable {
    static final long serialVersionUID = 1L
    String errorCode
    String errorMessage
    String key
    Serializable reference
    Serializable[] args
}
