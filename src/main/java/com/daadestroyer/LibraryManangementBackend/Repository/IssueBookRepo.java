package com.daadestroyer.LibraryManangementBackend.Repository;

import com.daadestroyer.LibraryManangementBackend.Entity.IssueBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueBookRepo extends JpaRepository<IssueBook, Integer> {
}