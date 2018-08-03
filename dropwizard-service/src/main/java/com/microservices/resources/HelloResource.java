package com.microservices.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Path("/api")
public class HelloResource {

    @GET
    @Path("/hello")
    public String hello() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostAddress();
        return "Hello Dropwizard de " + hostname;
    }

}
