package com.appchana.msclientgreeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientGreetingService {

    @Autowired
    protected RestTemplate restTemplate;
    protected String serviceUrl;

    public ClientGreetingService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http://" + serviceUrl;
    }

    // Invoke to greeting-service and return a Greeting object
    public Greeting greeting (String name) {
        Greeting greeting =  restTemplate.getForObject(serviceUrl + "/greeting/{name}", Greeting.class, name);
        return greeting;
    }
}
