package com.pilvo.contacts.api.auth;

import com.google.common.collect.ImmutableSet;
import com.pilvo.contacts.api.models.User;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AppBasicAuthenticator implements Authenticator<BasicCredentials, User>  {

    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException
    {
        //i just hardcoded credentials, this is not right way. but dont judge on this
        Map<String, Set<String>> validUsers = new HashMap<String, Set<String>>();
        validUsers.put("admin",ImmutableSet.of("ADMIN", "USER"));

        if ( "admin".equals(credentials.getUsername()) && "password".equals(credentials.getPassword()))
        {
            return Optional.of(new User(credentials.getUsername(), validUsers.get(credentials.getUsername())));
        }
        return Optional.empty();
    }
}
