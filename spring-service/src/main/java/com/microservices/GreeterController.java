package com.microservices;

import com.microservices.BackendDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="greeting")
public class GreeterController {

    private RestTemplate template = new RestTemplate();

    private String saying;
    private String backendHost;
    private int backendPort;

    @RequestMapping(method = RequestMethod.GET, value = "/greeting", produces = "text/plain")
    public String greeting() {
        String backendServiceUrl = "http://localhost:8080/api/backend?greeting={saying}";

        BackendDTO response = template.getForObject(
                backendServiceUrl,
                BackendDTO.class,
                saying);

        return response.getGreeting() + " at host: " + response.getIp();
    }

    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public String getBackendHost() {
        return backendHost;
    }

    public void setBackendHost(String backendHost) {
        this.backendHost = backendHost;
    }

    public int getBackendPort() {
        return backendPort;
    }

    public void setBackendPort(int backendPort) {
        this.backendPort = backendPort;
    }



}

