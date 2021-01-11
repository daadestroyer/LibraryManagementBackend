package com.daadestroyer.LibraryManangementBackend.Controller;

import com.daadestroyer.LibraryManangementBackend.Entity.Book_Details;
import com.daadestroyer.LibraryManangementBackend.Entity.Book_Publications;
import com.daadestroyer.LibraryManangementBackend.Repository.Book_Details_Repo;
import com.daadestroyer.LibraryManangementBackend.Repository.Book_Publications_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookDetailsController {


    @Autowired
    private Book_Publications_Repo book_publications_repo;
    @Autowired
    private Book_Details_Repo book_details_repo;


    @PostMapping("/add-book-details")
    public String addBookDetails(@RequestBody Book_Details book_details) {

        if (!book_publications_repo.findById(book_details.getBook_publications().getPublicationId()).isPresent()) {
            Book_Publications book_publications = new Book_Publications();
            book_publications.setPublicationId(book_details.getBook_publications().getPublicationId());
            book_publications.setPublicationName(book_details.getBook_publications().getPublicationName());
            book_details.setBook_publications(book_publications);
        }else {
            Optional<Book_Publications> book_publications_optional = book_publications_repo.findById(book_details.getBook_publications().getPublicationId());
            Book_Publications book_publications = book_publications_optional.get();
            book_details.setBook_publications(book_publications);
        }
        book_details_repo.save(book_details);
        return "Book Added...";
    }
}