package com.pilvo.contacts.api.data.services.factories;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.pilvo.contacts.api.common.Constants;
import com.pilvo.contacts.api.common.CustomErrorCodes;
import com.pilvo.contacts.api.common.ExceptionMessages;
import com.pilvo.contacts.api.data.services.AbstractDataService;
import com.pilvo.contacts.api.enums.Handler;
import com.pilvo.contacts.api.exceptions.HandlerNotFoundException;

public class DataServiceBuilderFactory {

    @Inject
    @Named(Constants.CONTACTS_DATA_SERVICE)
    AbstractDataService contactsDataService;

    public AbstractDataService getService(Handler Ehandle) throws HandlerNotFoundException {

        switch (Ehandle) {
            case CONTACT_SERVICE:
                return contactsDataService;
            default:
                throw new HandlerNotFoundException(ExceptionMessages.HANDLER_NOT_FOUND, null, CustomErrorCodes.SERVICE_INTERNAL_EXCEPTION);
        }
    }
}
