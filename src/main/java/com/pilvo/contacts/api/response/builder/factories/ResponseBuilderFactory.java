package com.pilvo.contacts.api.response.builder.factories;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.pilvo.contacts.api.common.Constants;
import com.pilvo.contacts.api.common.CustomErrorCodes;
import com.pilvo.contacts.api.common.ExceptionMessages;
import com.pilvo.contacts.api.enums.Handler;
import com.pilvo.contacts.api.exceptions.HandlerNotFoundException;
import com.pilvo.contacts.api.response.builder.AbstractResponseBuilder;

public class ResponseBuilderFactory {
    @Inject
    @Named(Constants.CONTACTS_RESPONSE_BUILDER)
    AbstractResponseBuilder contactsResponseBuilder;


    public AbstractResponseBuilder getResponseBuilder(Handler Ehandle) throws HandlerNotFoundException {
        switch (Ehandle) {
            case CONTACT_SERVICE:
                return contactsResponseBuilder;
            default:
                throw new HandlerNotFoundException(ExceptionMessages.HANDLER_NOT_FOUND, null, CustomErrorCodes.SERVICE_INTERNAL_EXCEPTION);
        }
    }
}
