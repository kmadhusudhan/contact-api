package com.pilvo.contacts.api.response.builder;

import com.pilvo.contacts.api.common.CustomErrorCodes;
import com.pilvo.contacts.api.common.HttpResponseCodes;
import com.pilvo.contacts.api.common.HttpResponseMessages;
import com.pilvo.contacts.api.exceptions.AbstractException;
import com.pilvo.contacts.api.exceptions.OperationFailedException;
import com.pilvo.contacts.api.models.AbstractModel;
import com.pilvo.contacts.api.models.ErrorResponseModel;
import com.pilvo.contacts.api.models.PaginationResponse;
import com.pilvo.contacts.api.models.SuccessResponseModel;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;

@Slf4j
public abstract class AbstractResponseBuilder<T extends AbstractModel> {

    public abstract Response buildFetchRecordResponse(T model) throws OperationFailedException;
    public Response buildFetchAllRecordsResponse(PaginationResponse paginationResponse) {
        return Response.status(CustomErrorCodes.HTTP_RESPONSE_SUCCESS.getValue()).entity(paginationResponse).build();
    }
    public  Response buildSuccessResponse() {
        SuccessResponseModel successResponseModel = new SuccessResponseModel();
        successResponseModel.setSuccessCode(HttpResponseCodes.HTTP_RESPONSE_SUCCESS);
        successResponseModel.setMessage(HttpResponseMessages.HTTP_RESPONSE_SUCCESS);
        return Response.status(HttpResponseCodes.HTTP_RESPONSE_SUCCESS).entity(successResponseModel).build();
    }
    public  Response buildErrorResponse(AbstractException e) {
        log.error(e.getMessage(),e);
        ErrorResponseModel errorResponseModel = new ErrorResponseModel();
        errorResponseModel.setErrorCode(e.getCode());
        errorResponseModel.setMessage(e.getMessage());
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(errorResponseModel).build();
    }
}
