package com.pilvo.contacts.api.response.builder;

import com.pilvo.contacts.api.exceptions.OperationFailedException;
import com.pilvo.contacts.api.models.Contact;

import javax.ws.rs.core.Response;

public class ContactResponseBuilder extends AbstractResponseBuilder<Contact> {
    public Response buildFetchRecordResponse(Contact model) throws OperationFailedException {
        return null;
    }
}
