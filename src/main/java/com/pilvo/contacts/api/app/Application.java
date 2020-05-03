package com.pilvo.contacts.api.app;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.pilvo.contacts.api.auth.AppBasicAuthenticator;
import com.pilvo.contacts.api.configuration.ContactConfiguration;
import com.pilvo.contacts.api.controllers.ContactsController;
import com.pilvo.contacts.api.auth.AppAuthorizer;
import com.pilvo.contacts.api.models.User;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;

public class Application extends io.dropwizard.Application<ContactConfiguration> {
    private GuiceBundle guiceBundle = GuiceBundle.<ContactConfiguration>newBuilder()
            .addModule(new AppBinder())
            .enableAutoConfig(getClass().getPackage().getName())
            .setConfigClass(ContactConfiguration.class)
            .build();

    @Override
    public void initialize(final Bootstrap<ContactConfiguration> bootstrap) {
        bootstrap.addBundle(guiceBundle);
    }

    public static void main(String[] args) throws Exception {
        new Application().run(args);
    }

    public void run(ContactConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI mysqlDB = factory.build(environment, configuration.getDatabase(), "mysqlDB");
        DBFactory dbFactory = new DBFactory(mysqlDB);

        environment.jersey().register(ContactsController.class);
        environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new AppBasicAuthenticator())
                .setAuthorizer(new AppAuthorizer())
                .setRealm("BASIC-AUTH-REALM")
                .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder(User.class));
    }
}
