package com.pilvo.contacts.api.handlers;

import com.google.inject.Inject;
import com.pilvo.contacts.api.data.services.factories.DataServiceBuilderFactory;
import com.pilvo.contacts.api.exceptions.HandlerNotFoundException;
import com.pilvo.contacts.api.models.PaginationResponse;
import com.pilvo.contacts.api.response.builder.factories.ResponseBuilderFactory;
import com.pilvo.contacts.api.validations.factories.ValidationBuilderFactory;

import javax.ws.rs.core.Response;

public abstract class AbstractHandler<T> {

    @Inject
    DataServiceBuilderFactory dataServiceBuilderFactory;

    @Inject
    ResponseBuilderFactory responseBuilderFactory;

    @Inject
    ValidationBuilderFactory validatorBuilderFactory;

    @Inject
    PaginationResponse paginationRecords;

    public abstract Response getAllRecords(T model) throws HandlerNotFoundException;
    public abstract Response createRecord(T model) throws HandlerNotFoundException;
    public abstract Response getRecord(T model) throws HandlerNotFoundException;
    public abstract Response updateRecord(T model) throws HandlerNotFoundException;
    public abstract Response deleteRecord(T model) throws HandlerNotFoundException;
}
