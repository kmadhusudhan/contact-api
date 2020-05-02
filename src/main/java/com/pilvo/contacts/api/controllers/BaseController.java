package com.pilvo.contacts.api.controllers;

import com.google.inject.Inject;
import com.pilvo.contacts.api.exceptions.handlers.ExceptionHandler;
import com.pilvo.contacts.api.handlers.factories.HandleFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Data
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class BaseController {
    @Inject
    private HandleFactory handlerFactory;
    @Inject
    private ExceptionHandler exceptionHandler;
}
