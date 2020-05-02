package com.pilvo.contacts.api.app;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.pilvo.contacts.api.configuration.ContactConfiguration;
import com.pilvo.contacts.api.controllers.ContactsController;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class Application extends io.dropwizard.Application<ContactConfiguration> {
    private GuiceBundle guiceBundle = GuiceBundle.<ContactConfiguration>newBuilder()
            .addModule(new AppBinder())
            .enableAutoConfig(getClass().getPackage().getName())
            .setConfigClass(ContactConfiguration.class)
            .build();


    public static void main(String[] args) throws Exception {
        new Application().run(args);
    }

    public void run(ContactConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI mysqlDB = factory.build(environment, configuration.getDatabase(), "mysqlDB");
        DBFactory dbFactory = new DBFactory(mysqlDB);

        environment.jersey().register(ContactsController.class);
    }
}
