package com.daadestroyer.LibraryManangementBackend.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Borrower_Details {

    @Id
    private int borrowerId;

    @OneToOne(cascade = CascadeType.ALL)
    private Book_Details book_details;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date borrowedFrom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;

    public Borrower_Details() {
    }

    public Borrower_Details(int borrowerId, Book_Details book_details, Date borrowedFrom, Date returnDate) {
        this.borrowerId = borrowerId;
        this.book_details = book_details;
        this.borrowedFrom = borrowedFrom;
        this.returnDate = returnDate;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Book_Details getBook_details() {
        return book_details;
    }

    public void setBook_details(Book_Details book_details) {
        this.book_details = book_details;
    }

    public Date getBorrowedFrom() {
        return borrowedFrom;
    }

    public void setBorrowedFrom(Date borrowedFrom) {
        this.borrowedFrom = borrowedFrom;
    }


    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrower_Details{" +
                "borrowerId=" + borrowerId +
                ", book_details=" + book_details +
                ", borrowedFrom=" + borrowedFrom +
                ", returnDate=" + returnDate +
                '}';
    }
}
