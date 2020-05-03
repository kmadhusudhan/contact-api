package com.pilvo.contacts.api.common;

public enum CustomErrorCodes {
    HTTP_RESPONSE_SUCCESS(200),
    BAD_REQUEST(400),
    FORBIDDEN(403),

    INTERNAL_ERROR(500),
    //custom errors
    SERVICE_INTERNAL_EXCEPTION(1001),
    CONTACT_ID_REQUIRED(1003),
    INVALID_EMAIL(1004),
    EMAIL_ALREADY_EXISTS(1005);

    //custom codes
    private final int value;
    private CustomErrorCodes(int value)
    {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
