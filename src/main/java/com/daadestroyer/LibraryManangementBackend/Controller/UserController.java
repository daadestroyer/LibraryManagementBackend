package com.daadestroyer.LibraryManangementBackend.Controller;

import com.daadestroyer.LibraryManangementBackend.Entity.User;
import com.daadestroyer.LibraryManangementBackend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;


    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user) {
        this.userRepo.save(user);
        return "User Created";
    }


}
