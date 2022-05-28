package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {


    // Get
    // URI - /hello-world
    // method - return "Hello, World"
     @GetMapping( path = "/hello-world")
     public String helloWorld() {
         return "Hello World";
     }

    // FURTHER SIMPLIFY RequestMapping to @GetMapping, example below
    // Notice there's no need for method = RequestMethod.GET
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
         return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
