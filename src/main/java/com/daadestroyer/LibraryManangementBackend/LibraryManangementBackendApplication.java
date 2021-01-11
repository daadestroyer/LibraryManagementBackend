package com.daadestroyer.LibraryManangementBackend;

import com.daadestroyer.LibraryManangementBackend.Repository.Book_Details_Repo;
import com.daadestroyer.LibraryManangementBackend.Repository.Book_Publications_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManangementBackendApplication {


    @Autowired
    private Book_Publications_Repo book_publications_repo;
    @Autowired
    private Book_Details_Repo book_details_repo;

    public static void main(String[] args) {
        SpringApplication.run(LibraryManangementBackendApplication.class, args);
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("STARTED");
        System.out.println("-----------------");
        System.out.println("-----------------");
    }

}
