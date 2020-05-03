package com.pilvo.contacts.api.validations;

import com.google.inject.Inject;
import com.pilvo.contacts.api.common.CustomErrorCodes;
import com.pilvo.contacts.api.common.ExceptionMessages;
import com.pilvo.contacts.api.enums.Handler;
import com.pilvo.contacts.api.exceptions.AbstractException;
import com.pilvo.contacts.api.exceptions.ValidationFailedException;
import com.pilvo.contacts.api.models.Contact;
import com.pilvo.contacts.api.util.EmailOperations;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContactsValidator extends AbstractValidation<Contact> {
    @Inject
    EmailOperations emailOperations;

    public Contact createRecordValidations(Contact model) throws ValidationFailedException {
        Contact contact = null;
        try {
            contact = (Contact) dataServiceBuilderFactory.getService(Handler.CONTACT_SERVICE).fetchRecordByName(model);
            emailOperations.isValidEmail(model.getEmail());
        } catch (NullPointerException ne) {
            throw new ValidationFailedException(ExceptionMessages.INVALID_EMAIL, null, CustomErrorCodes.INVALID_EMAIL);
        } catch (AbstractException e) {
            log.error("Exception while validating contact record", e);
        }
        if (contact != null)
            throw new ValidationFailedException(ExceptionMessages.CONTACT_ALREADY_EXISTS, null, CustomErrorCodes.EMAIL_ALREADY_EXISTS);
        return model;
    }

    public void fetchRecordValidations(long id) throws ValidationFailedException {
        validateId(id);
    }

    public void updateRecordValidations(Contact model) throws ValidationFailedException {
        validateId(model.getId());
    }

    public void deleteRecordValidations(long id) throws ValidationFailedException {
        validateId(id);
    }

    private void validateId(long id) throws ValidationFailedException {
        if (id == 0) {
            throw new ValidationFailedException(ExceptionMessages.CONTACT_ID_REQUIRED, null, CustomErrorCodes.CONTACT_ID_REQUIRED);
        }
    }
}
