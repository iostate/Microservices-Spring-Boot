package com.in28minutes.rest.webservices.restfulwebservices.user;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Eric", new Date()));

    }

     public List<User> findAll() {
        return users;
     }

    /**
     * Returns true if the User was added. False if not.
     *
     * @param user User to be added to users.
     * @return boolean True if the User was added
     */
     public User save(User user) {
        // if the user has no id
        if (user.getId()==null) {
            user.setId(++usersCount);
        }
         users.add(user);
         return user;
     }
     public User findOne(int id) {
         for (User user:users) {
             if(user.getId()==id) {
                 return user;
             }
         }
         return null;
     }

}
