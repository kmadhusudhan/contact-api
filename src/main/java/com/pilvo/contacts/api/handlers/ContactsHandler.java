package com.pilvo.contacts.api.handlers;

import com.pilvo.contacts.api.enums.Handler;
import com.pilvo.contacts.api.exceptions.AbstractException;
import com.pilvo.contacts.api.exceptions.HandlerNotFoundException;
import com.pilvo.contacts.api.models.Contact;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;

@Slf4j
public class ContactsHandler extends AbstractHandler<Contact> {

    public Response getAllRecords(Contact model) throws HandlerNotFoundException {
        try {
            paginationRecords = dataServiceBuilderFactory.getService(Handler.CONTACT_SERVICE).getAllRecords(model);
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildFetchAllRecordsResponse(paginationRecords);
        } catch(AbstractException e){
            log.error("Exception while fetching all record");
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildErrorResponse(e);
        }
    }

    public Response createRecord(Contact model) throws HandlerNotFoundException {
        try {
            validatorBuilderFactory.getValidator(Handler.CONTACT_SERVICE).createRecordValidations(model);
            dataServiceBuilderFactory.getService(Handler.CONTACT_SERVICE).createRecord(model);
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildSuccessResponse();
        }  catch(AbstractException e){
            log.error("Exception while creating record");
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildErrorResponse(e);
        }

    }

    public Response getRecord(Contact model) throws HandlerNotFoundException {
        try {
             validatorBuilderFactory.getValidator(Handler.CONTACT_SERVICE).fetchRecordValidations(model.getId());
             Contact contact =  (Contact) dataServiceBuilderFactory.getService(Handler.CONTACT_SERVICE).fetchRecordById(model.getId());
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildFetchRecordResponse(contact);
        }  catch(AbstractException e){
            log.error("Exception while fetching record");
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildErrorResponse(e);
        }
    }

    public Response updateRecord(Contact model) throws HandlerNotFoundException {
        try {
            validatorBuilderFactory.getValidator(Handler.CONTACT_SERVICE).updateRecordValidations(model);
            dataServiceBuilderFactory.getService(Handler.CONTACT_SERVICE).updateRecord(model);
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildSuccessResponse();
        }  catch(AbstractException e){
            log.error("Exception while updating record");
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildErrorResponse(e);
        }
    }

    public Response deleteRecord(Contact model) throws HandlerNotFoundException {
        try {
            validatorBuilderFactory.getValidator(Handler.CONTACT_SERVICE).deleteRecordValidations(model.getId());
            dataServiceBuilderFactory.getService(Handler.CONTACT_SERVICE).deleteRecord(model);
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildSuccessResponse();
        }  catch(AbstractException e){
            log.error("Exception while deleting record");
            return responseBuilderFactory.getResponseBuilder(Handler.CONTACT_SERVICE).buildErrorResponse(e);
        }
    }
}
