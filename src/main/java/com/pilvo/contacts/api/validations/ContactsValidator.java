package com.pilvo.contacts.api.validations;

import com.pilvo.contacts.api.exceptions.ValidationFailedException;
import com.pilvo.contacts.api.models.Contact;

public class ContactsValidator extends AbstractValidation<Contact> {
    public Contact createRecordValidations(Contact model) throws ValidationFailedException {
        return null;
    }

    public Contact fetchRecordValidations(int id) {
        return null;
    }

    public void updateRecordValidations(Contact model) {

    }

    public void deleteRecordValidations(int id) {

    }
}
