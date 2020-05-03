package com.pilvo.contacts.api.auth;

import com.pilvo.contacts.api.models.User;
import io.dropwizard.auth.Authorizer;

public class AppAuthorizer implements Authorizer<User> {
    public boolean authorize(User user, String role) {
        return user.getRoles() != null && user.getRoles().contains(role);
    }
}
