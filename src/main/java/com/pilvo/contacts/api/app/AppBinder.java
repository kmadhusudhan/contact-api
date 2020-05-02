package com.pilvo.contacts.api.app;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.olacabs.training.application.bootstrap.DBFactory;
import com.pilvo.contacts.api.common.Constants;
import com.pilvo.contacts.api.dao.ContactDAO;
import com.pilvo.contacts.api.data.services.AbstractDataService;
import com.pilvo.contacts.api.data.services.ContactDataService;
import com.pilvo.contacts.api.handlers.AbstractHandler;
import com.pilvo.contacts.api.handlers.ContactsHandler;
import com.pilvo.contacts.api.response.builder.AbstractResponseBuilder;
import com.pilvo.contacts.api.response.builder.ContactResponseBuilder;
import com.pilvo.contacts.api.validations.AbstractValidation;
import com.pilvo.contacts.api.validations.ContactsValidator;

public class AppBinder extends AbstractModule  {
    protected void configure() {

        //handlers
        bind(AbstractHandler.class).annotatedWith(Names.named(Constants.CONTACTS_HANDLER)).to(ContactsHandler.class);


        //validations
        bind(AbstractValidation.class).annotatedWith(Names.named(Constants.CONTACTS_VALIDATOR)).to(ContactsValidator.class);

        //data services
        bind(AbstractDataService.class).annotatedWith(Names.named(Constants.CONTACTS_DATA_SERVICE)).to(ContactDataService.class);

        //response builders
        bind(AbstractResponseBuilder.class).annotatedWith(Names.named(Constants.CONTACTS_RESPONSE_BUILDER)).to(ContactResponseBuilder.class);

    }

    @Provides
    @Named(Constants.CONTACTS_DAO)
    public ContactDAO getContactDAO() {
        return DBFactory.getDBI().onDemand(ContactDAO.class);
    }
}
