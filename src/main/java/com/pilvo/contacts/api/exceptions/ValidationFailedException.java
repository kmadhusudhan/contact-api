package com.pilvo.contacts.api.exceptions;


import com.pilvo.contacts.api.common.CustomErrorCodes;

public class ValidationFailedException  extends AbstractException {
    public ValidationFailedException(String message, Throwable t, CustomErrorCodes code) {
        super(message, t, code);
    }
}
