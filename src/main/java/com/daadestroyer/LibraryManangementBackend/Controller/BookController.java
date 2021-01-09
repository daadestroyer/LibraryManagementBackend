package com.daadestroyer.LibraryManangementBackend.Controller;

import com.daadestroyer.LibraryManangementBackend.Entity.Book;
import com.daadestroyer.LibraryManangementBackend.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    // add-book API
    @PostMapping("/add-book")
    @ResponseStatus(HttpStatus.CREATED)
    public String addBook(@RequestBody Book book){
            this.bookRepo.save(book);
            return "Book Created";
    }

    // get-book by Id API
    @GetMapping("/get-book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id){
        Optional<Book> book = this.bookRepo.findById(id);
        if(book.isPresent()){
            return new ResponseEntity<>(book, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>("Book Not Found...", HttpStatus.NOT_FOUND);
        }
    }
}