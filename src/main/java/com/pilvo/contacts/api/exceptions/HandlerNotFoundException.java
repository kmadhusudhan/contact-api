package com.pilvo.contacts.api.exceptions;


import com.pilvo.contacts.api.common.CustomErrorCodes;

public class HandlerNotFoundException extends AbstractException {
    public HandlerNotFoundException(String message, Throwable t, CustomErrorCodes code) {
        super(message, t, code);
    }
}
