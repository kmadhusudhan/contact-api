package com.pilvo.contacts.api.response.builder;

import com.pilvo.contacts.api.common.CustomErrorCodes;
import com.pilvo.contacts.api.exceptions.OperationFailedException;
import com.pilvo.contacts.api.models.Contact;
import com.pilvo.contacts.api.models.ContactResponse;
import com.pilvo.contacts.api.models.PaginationResponse;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class ContactResponseBuilder extends AbstractResponseBuilder<Contact> {

    public Response buildFetchAllRecordsResponse(PaginationResponse paginationResponse) throws OperationFailedException {
        List<Contact> contactList = paginationResponse.getItems();
        List<ContactResponse> contactResponseList = new ArrayList<ContactResponse>();
        for (Contact contact: contactList) {
            contactResponseList.add(buildContactResponse(contact));
        }
        paginationResponse.setItems(contactResponseList);
        return Response.status(CustomErrorCodes.HTTP_RESPONSE_SUCCESS.getValue()).entity(paginationResponse).build();
    }

    public Response buildFetchRecordResponse(Contact model) throws OperationFailedException {
        ContactResponse contactResponse = buildContactResponse(model);
        return Response.status(CustomErrorCodes.HTTP_RESPONSE_SUCCESS.getValue()).entity(contactResponse).build();
    }

    ContactResponse buildContactResponse(Contact model) {
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setName(model.getName());
        contactResponse.setEmail(model.getEmail());
        contactResponse.setId(model.getId());
        contactResponse.setPhonenumber(model.getPhoneNumber());
        return contactResponse;
    }
}
