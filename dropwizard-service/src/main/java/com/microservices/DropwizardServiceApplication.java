package com.microservices;

import com.microservices.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardServiceApplication extends Application<DropwizardServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardService";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardServiceConfiguration> bootstrap) {

    }

    @Override
    public void run(final DropwizardServiceConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new HelloResource());
    }

}
