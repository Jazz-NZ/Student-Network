package com.studentnetwork.Student.Network.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public Group[] getJsonAsObject() {
        String url = "http://localhost:8083/groups";
        System.out.println();
        return this.restTemplate.getForObject(url, Group[].class);
    }

    public String getJsonAsString(){
        String url = "http://localhost:8083/groups";
        return this.restTemplate.getForObject(url, String.class);
    }
}
