package com.daadestroyer.LibraryManangementBackend.Controller;

import com.daadestroyer.LibraryManangementBackend.Entity.Book;
import com.daadestroyer.LibraryManangementBackend.Entity.User;
import com.daadestroyer.LibraryManangementBackend.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    // add-book API
    @PostMapping("/add-book")
    @ResponseStatus(HttpStatus.CREATED)
    public String addBook(@RequestBody Book book) {
        this.bookRepo.save(book);
        return "Book Created";
    }

    // get-book by Id API
    @GetMapping("/get-book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Optional<Book> book = this.bookRepo.findById(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(book, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("Book Not Found...", HttpStatus.NOT_FOUND);
        }
    }

    //get-all-book API
    @GetMapping("/get-all-book")
    public List<Book> getAllBook() {
        List<Book> book = this.bookRepo.findAll();
        return book;
    }

    //search-book-by-author API
    @GetMapping("/search-book-by-author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author) {
        List<Book> books = this.bookRepo.findAll();
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                list.add(book);
            }
        }
        return list;
    }

    //search-book-by-subject API
    @GetMapping("/search-book-by-subject/{subject}")
    public List<Book> getAllBookBySubject(@PathVariable String subject) {
        List<Book> books = this.bookRepo.findAll();
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getSubject().equals(subject)) {
                list.add(book);
            }
        }
        return list;
    }

    //search-book-by-isbn API
    @GetMapping("/search-book-by-isbn/{isbn}")
    public List<Book> getAllBookByIsbn(@PathVariable String isbn) {
        List<Book> books = this.bookRepo.findAll();
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn_number().equals(isbn)) {
                list.add(book);
            }
        }
        return list;
    }

    //delete-book-by-id API
    @DeleteMapping("/delete-book-by-id/{id}")
    public String deleteUserById(@PathVariable int id) {
        Optional<Book> optionalUser = this.bookRepo.findById(id);
        if (!optionalUser.isPresent()) {
            return "Book not found...";
        } else {
            this.bookRepo.deleteById(id);
            return "Book " + id + " deleted successfully...";
        }
    }

    //delete-all-user API
    @DeleteMapping("/delete-all-book")
    public String deleteAllUsers() {
        List<Book> list = this.bookRepo.findAll();
        if(list.size()>0){
            this.bookRepo.deleteAll();
            return "All book deleted successfully...";
        }
        else{
            return "No book exist...";
        }
    }
}