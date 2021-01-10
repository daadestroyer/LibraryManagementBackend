package com.daadestroyer.LibraryManangementBackend.Controller;

import com.daadestroyer.LibraryManangementBackend.Entity.Book;
import com.daadestroyer.LibraryManangementBackend.Entity.IssueBook;
import com.daadestroyer.LibraryManangementBackend.Repository.BookRepo;
import com.daadestroyer.LibraryManangementBackend.Repository.IssueBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class IssueBookController {

    @Autowired
    private IssueBookRepo issueBookRepo;
    private BookRepo bookRepo;

    @PostMapping("/book-issue")
    @ResponseStatus(HttpStatus.CREATED)
    public String issueBook(@RequestBody IssueBook issueBook) {
        /*
        Optional<Book> list = this.bookRepo.findById(issueBook.getId());
        Book book = list.get();

        for (Book book : list) {
            if(book.getId() == issueBook.getBook_id()){
                System.out.println("FOUND");
            }
        }*/
        System.out.println(issueBook.getBook_id());
        return "";
    }


}