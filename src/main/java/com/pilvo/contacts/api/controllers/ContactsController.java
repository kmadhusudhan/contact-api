package com.pilvo.contacts.api.controllers;

import com.pilvo.contacts.api.enums.Handler;
import com.pilvo.contacts.api.exceptions.AbstractException;
import com.pilvo.contacts.api.models.Contact;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("api/v1/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactsController extends BaseController {

    @POST
    @Path("/list")
    public Response getAll(@Valid Contact contact) {
        try {
            return this.getHandlerFactory().getHandler(Handler.CONTACT_SERVICE).getAllRecords(contact);
        } catch (AbstractException e) {
            log.error("Error while getting contacts =>", e);
            return this.getExceptionHandler().handle(e);
        }
    }

    @POST
    @Path("/create")
    public Response create(@Valid Contact contact) {
        try {
            return this.getHandlerFactory().getHandler(Handler.CONTACT_SERVICE).createRecord(contact);
        } catch (AbstractException e) {
            log.error("Error while creating contacts  =>", e);
            return this.getExceptionHandler().handle(e);
        }
    }


    @PUT
    @Path("/update")
    public Response update(@Valid Contact contact) {
        try {
            return this.getHandlerFactory().getHandler(Handler.CONTACT_SERVICE).updateRecord(contact);
        } catch (AbstractException e) {
            log.error("Error while updating contact =>", e);
            return this.getExceptionHandler().handle(e);
        }
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        try {
            Contact contact = new Contact();
            contact.setId(id);
            return this.getHandlerFactory().getHandler(Handler.CONTACT_SERVICE).deleteRecord(contact);
        } catch (AbstractException e) {
            log.error("Error while deleting contact =>", e);
            return this.getExceptionHandler().handle(e);
        }
    }
}
