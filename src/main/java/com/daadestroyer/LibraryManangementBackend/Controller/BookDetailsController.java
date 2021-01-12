package com.daadestroyer.LibraryManangementBackend.Controller;

import com.daadestroyer.LibraryManangementBackend.Entity.Book_Category;
import com.daadestroyer.LibraryManangementBackend.Entity.Book_Details;
import com.daadestroyer.LibraryManangementBackend.Entity.Book_Publications;
import com.daadestroyer.LibraryManangementBackend.Repository.Book_Category_Repo;
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
    @Autowired
    private Book_Category_Repo book_category_repo;


    @PostMapping("/add-book-details")
    public String addBookDetails(@RequestBody Book_Details book_details) {
        if (!book_publications_repo.findById(book_details.getBook_publications().getPublicationId()).isPresent()) {
            Book_Publications book_publications = new Book_Publications();
            book_publications.setPublicationId(book_details.getBook_publications().getPublicationId());
            book_publications.setPublicationName(book_details.getBook_publications().getPublicationName());
            Book_Category bookCategory = new Book_Category();
            bookCategory.setCategory_id(book_details.getBook_Category().getCategory_id());
            bookCategory.setCategory_name(book_details.getBook_Category().getCategory_name());
            book_details.setBook_Category(bookCategory);
            book_details.setBook_publications(book_publications);
        }else {
            Optional<Book_Publications> book_publications_optional = book_publications_repo.findById(book_details.getBook_publications().getPublicationId());
            Book_Publications book_publications = book_publications_optional.get();
            book_details.setBook_publications(book_publications);
            Optional<Book_Category> book_category_optional = book_category_repo.findById(book_details.getBook_Category().getCategory_id());
            Book_Category book_category = book_category_optional.get();
            book_details.setBook_Category(book_category);
        }
        book_details_repo.save(book_details);
        return "Book Added...";
    }

    @GetMapping("/get-categories")
    public List<Book_Category> getAllCategory(){
        List<Book_Category> book_categories = this.book_category_repo.findAll();
        return book_categories;
    }

    @GetMapping("/get-publication")
    public List<Book_Publications> getPublications(){
        List<Book_Publications> book_publications = this.book_publications_repo.findAll();
        return book_publications;
    }

}