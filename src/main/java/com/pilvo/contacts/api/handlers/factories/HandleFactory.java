package com.pilvo.contacts.api.handlers.factories;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.pilvo.contacts.api.common.Constants;
import com.pilvo.contacts.api.common.CustomErrorCodes;
import com.pilvo.contacts.api.common.ExceptionMessages;
import com.pilvo.contacts.api.enums.Handler;
import com.pilvo.contacts.api.exceptions.HandlerNotFoundException;
import com.pilvo.contacts.api.handlers.AbstractHandler;

public class HandleFactory {

    @Inject
    @Named(Constants.CONTACTS_HANDLER)
    AbstractHandler contactsHandler;


    public AbstractHandler getHandler(Handler handleEnum) throws HandlerNotFoundException {
        switch (handleEnum) {
            case CONTACT_SERVICE:
                return contactsHandler;
            default:
                throw new HandlerNotFoundException(ExceptionMessages.HANDLER_NOT_FOUND, null, CustomErrorCodes.SERVICE_INTERNAL_EXCEPTION);
        }
    }
}
