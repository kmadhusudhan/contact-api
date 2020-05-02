package com.pilvo.contacts.api.models;


import com.pilvo.contacts.api.common.CustomErrorCodes;

public  class AbstractResponse {
    private String message;
    private int successCode;
    private int errorCode;

    public void setErrorCode(CustomErrorCodes code) {
        this.errorCode = code.getValue();
    }
    public void setSuccessCode(int code) {
        this.successCode = code;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getErrorCode(){
        return errorCode;
    }
    public int getSuccessCode(){
        return errorCode;
    }
    public String getMessage(){
        return message;
    }
}
