package com.daadestroyer.LibraryManangementBackend.Controller;

import com.daadestroyer.LibraryManangementBackend.Entity.Book_Details;
import com.daadestroyer.LibraryManangementBackend.Entity.Borrower_Details;
import com.daadestroyer.LibraryManangementBackend.Repository.Book_Details_Repo;
import com.daadestroyer.LibraryManangementBackend.Repository.Borrower_Details_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Borrower_Details_Controller {

    @Autowired
    private Borrower_Details_Repo borrower_details_repo;

    @Autowired
    private Book_Details_Repo book_details_repo;

    @PostMapping("/add-borrower")
    public String addBorrower(@RequestBody Borrower_Details borrower_details) {
        if(book_details_repo.findById(borrower_details.getBook_details().getBookISBN()).isPresent() && !borrower_details_repo.findById(borrower_details.getBorrowerId()).isPresent()){
            this.borrower_details_repo.save(borrower_details);
            return "Book Issued";
        }else{
            return "Borrower With this Id " + borrower_details.getBorrowerId() + " Not Saved inside the database";
        }
    }
}
