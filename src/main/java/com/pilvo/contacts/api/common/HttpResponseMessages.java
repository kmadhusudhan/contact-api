package com.pilvo.contacts.api.common;

public class HttpResponseMessages {
    public static final String FORBIDDEN = "Access Denied";
    public static final String LOCKED = "Resource Access locked";
    public static final String UNAUTHORIZED = "The Credential provided is not valid or expired";
    public static final String FAILED = "Request failed please retry";
    public static String HTTP_RESPONSE_SUCCESS = "The Request is completed Successfully";
    public static String HTTP_RESPONSE_REDIRECT = "The Request is completed Successfully but server requires the client redirect";
    public static String QUERY_FAILED = "The requested data is not available";
    public static final String INVALID_CREDENTIALS = "Invalid Credentials";
    public static final String UNAUTHORIZED_JSON = "{\"message\":\"Your not authorized\"}";
}
