package com.in28minutes.rest.webservices.restfulwebservices.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    public UserDaoService service;


    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }
}
