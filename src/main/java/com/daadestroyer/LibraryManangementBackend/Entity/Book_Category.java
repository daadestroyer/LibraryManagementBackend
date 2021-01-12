package com.daadestroyer.LibraryManangementBackend.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book_Category {

    @Id
    private int category_id;

    private String category_name;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Book_Category() {
    }

    public Book_Category(int category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Book_Category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
