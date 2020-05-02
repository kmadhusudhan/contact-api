package com.pilvo.contacts.api.exceptions.handlers;

import com.pilvo.contacts.api.common.CustomErrorCodes;
import com.pilvo.contacts.api.exceptions.AbstractException;
import com.pilvo.contacts.api.models.ErrorResponseModel;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;

@Slf4j
public class ExceptionHandler {
    public Response handle(AbstractException exception)  {
        ErrorResponseModel model = new ErrorResponseModel();
        model.setErrorCode(exception.getCode());
        model.setMessage(exception.getCode().name());
        log.error("Unknown error...", exception);
        return Response.status(CustomErrorCodes.INTERNAL_ERROR.getValue()).entity(model).build();
    }
}
