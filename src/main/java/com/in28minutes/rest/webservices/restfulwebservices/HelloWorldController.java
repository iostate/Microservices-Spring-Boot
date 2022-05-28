package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {


    // Get
    // URI - /hello-world
    // method - return "Hello, World"
     @GetMapping( path = "/hello_world")
     public String helloWorld() {
         return "Hello World";
     }

    // FURTHER SIMPLIFY RequestMapping to @GetMapping, example below
    // Notice there's no need for method = RequestMethod.GET
    @GetMapping(path = "/hello_world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    // Similarly, there's PostMapping, etc
}
