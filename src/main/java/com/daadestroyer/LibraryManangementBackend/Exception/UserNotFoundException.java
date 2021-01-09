package com.daadestroyer.LibraryManangementBackend.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id){
        super("User ID Not Found: " + id);
    }
}
