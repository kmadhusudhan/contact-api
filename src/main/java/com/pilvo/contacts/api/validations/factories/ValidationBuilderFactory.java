package com.pilvo.contacts.api.validations.factories;


import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.pilvo.contacts.api.common.Constants;
import com.pilvo.contacts.api.common.CustomErrorCodes;
import com.pilvo.contacts.api.common.ExceptionMessages;
import com.pilvo.contacts.api.enums.Handler;
import com.pilvo.contacts.api.exceptions.HandlerNotFoundException;
import com.pilvo.contacts.api.validations.AbstractValidation;

public class ValidationBuilderFactory {
    @Inject
    @Named(Constants.CONTACTS_VALIDATOR)
    AbstractValidation contactsValidator;



    public AbstractValidation getValidator(Handler handler) throws HandlerNotFoundException {
        switch (handler) {
            case CONTACT_SERVICE:
                return contactsValidator;
            default:
                throw new HandlerNotFoundException(ExceptionMessages.HANDLER_NOT_FOUND, null, CustomErrorCodes.SERVICE_INTERNAL_EXCEPTION);
        }
    }
}
