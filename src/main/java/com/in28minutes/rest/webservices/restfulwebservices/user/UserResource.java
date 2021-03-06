package com.in28minutes.rest.webservices.restfulwebservices.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {


    @Autowired
    public UserDaoService service;


    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }



    // GET /users/{id}
    // if users[id] == null then Throw 404
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException(String.format("User w/ ID #%d Was Not Found!", id) +
                    "\n" + "Please try searching for another User ID #");
        }
        return user;
    }

    /**
     * A route that allows a user to be deleted with an ID.
     * @param id The ID of the User to be deleted.
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        // DELETE
        // /user/{id}
        User user = service.deleteOne(id);
        if (user == null) {
            throw new UserNotFoundException(String.format("User w/ ID #%d Was Not Found! Please try searching for another User ID.", id));
        }
    }



    /**
     * Takes either an ID or a User.
     * @param parameter
     * @return
     */
    public URI buildUri(Object parameter) {
        Integer userId;
//        if (parameter instanceof User) {
//            userId = ((User) parameter).getId();
//        } else if (parameter instanceof Integer) {
//            userId = ((Integer) parameter);
//        } else {
//            userId = 0;
//        }

        if (parameter instanceof User) {
            userId = ((User) parameter).getId();
        } else {
            userId = ((Integer) parameter);
        }


           URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(userId).toUri();


        return location;



    }

    /**
     *
     * @param user The details of the user (name & birth-date, id gets generated
     *             by itself.
     */
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        // CREATED
        // /user/{id}       savedUser.getId()

        URI location =
                ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }



}
