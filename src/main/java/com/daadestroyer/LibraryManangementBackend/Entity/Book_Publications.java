package com.daadestroyer.LibraryManangementBackend.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book_Publications {
    @Id
    private int publicationId;
    private String publicationName;

    public int getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(int publicationId) {
        this.publicationId = publicationId;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public Book_Publications(){
        super();
    }

    public Book_Publications(int publicationId, String publicationName) {
        this.publicationId = publicationId;
        this.publicationName = publicationName;
    }

    @Override
    public String toString() {
        return "Book_Publications{" +
                "publicationId=" + publicationId +
                ", publicationName='" + publicationName + '\'' +
                '}';
    }
}
