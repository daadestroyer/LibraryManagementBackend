package com.daadestroyer.LibraryManangementBackend.Controller;

import com.daadestroyer.LibraryManangementBackend.Entity.Book;
import com.daadestroyer.LibraryManangementBackend.Entity.IssueBook;
import com.daadestroyer.LibraryManangementBackend.Repository.BookRepo;
import com.daadestroyer.LibraryManangementBackend.Repository.IssueBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class IssueBookController {

    @Autowired
    private IssueBookRepo issueBookRepo;
    @Autowired
    private BookRepo bookRepo;

    // get-all-issued-book-by-book-id API
    @GetMapping("/get-all-issued-book-by-book-id/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<IssueBook> getIssuedBookById(@PathVariable int id){
        List<IssueBook> issueBookList = this.issueBookRepo.findAll();
        ArrayList<IssueBook> foundAllBookList = new ArrayList<>();
        for(IssueBook bookIssue : issueBookList){
            if(bookIssue.getBook_id() == id){
                foundAllBookList.add(bookIssue);
            }
        }
        return foundAllBookList;
    }

    // book-issue API
    @PostMapping("/book-issue")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> issueBook(@RequestBody IssueBook issueBook) {
        Optional<Book> bookOptional = this.bookRepo.findById(issueBook.getBook_id());
        if (bookOptional.isPresent()) {
            this.issueBookRepo.save(issueBook);
            return new ResponseEntity<>("Book " + issueBook.getBook_id() + " issued to user id " + issueBook.getUser_id() + " ...", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Book not exist...", HttpStatus.NOT_FOUND);
        }
    }
}