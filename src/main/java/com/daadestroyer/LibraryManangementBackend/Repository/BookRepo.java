package com.daadestroyer.LibraryManangementBackend.Repository;

import com.daadestroyer.LibraryManangementBackend.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}