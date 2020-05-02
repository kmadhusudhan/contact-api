package com.pilvo.contacts.api.exceptions;


import com.pilvo.contacts.api.common.CustomErrorCodes;

public class OperationFailedException extends AbstractException {
    public OperationFailedException(String message, Throwable t, CustomErrorCodes code) {
        super(message, t, code);
    }
}
