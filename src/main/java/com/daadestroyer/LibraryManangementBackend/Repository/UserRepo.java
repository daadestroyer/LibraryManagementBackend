package com.daadestroyer.LibraryManangementBackend.Repository;

import com.daadestroyer.LibraryManangementBackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
