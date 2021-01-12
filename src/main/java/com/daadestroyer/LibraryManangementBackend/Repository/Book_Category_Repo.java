package com.daadestroyer.LibraryManangementBackend.Repository;

import com.daadestroyer.LibraryManangementBackend.Entity.Book_Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Book_Category_Repo extends JpaRepository<Book_Category, Integer> {
}