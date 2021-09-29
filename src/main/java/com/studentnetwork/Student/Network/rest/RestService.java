package com.studentnetwork.Student.Network.rest;

import com.studentnetwork.Student.Network.database.GroupDB;
import com.studentnetwork.Student.Network.database.PostDB;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public PostDB[] getJsonAsObject(int userId) {

        String url = "http://localhost:8083/users/"+ userId;
        return this.restTemplate.getForObject(url, PostDB[].class);
    }

    public String getJsonAsString(){
        String url = "http://localhost:8083/groups";
        return this.restTemplate.getForObject(url, String.class);
    }

    public GroupDB[] getGroupsAsObject(String groupName){

        String url = "http://localhost:8083/search/"+ groupName;
        return this.restTemplate.getForObject(url, GroupDB[].class);

    }
}
