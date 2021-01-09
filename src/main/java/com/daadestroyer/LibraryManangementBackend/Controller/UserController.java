package com.daadestroyer.LibraryManangementBackend.Controller;

import com.daadestroyer.LibraryManangementBackend.Entity.User;
import com.daadestroyer.LibraryManangementBackend.Exception.UserNotFoundException;
import com.daadestroyer.LibraryManangementBackend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    // add user API
    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user) {
        this.userRepo.save(user);
        return "User Created";
    }

    // get-user API
    @GetMapping("/get-user/{user_id}")
    public ResponseEntity<?> getUser(@PathVariable int user_id){

        Optional<User> user = this.userRepo.findById(user_id);
        if(user.isPresent()){
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("User Not Found...", HttpStatus.NOT_FOUND);
        }
        
    }


}