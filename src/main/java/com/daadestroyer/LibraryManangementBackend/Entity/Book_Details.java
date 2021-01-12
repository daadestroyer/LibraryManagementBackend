package com.daadestroyer.LibraryManangementBackend.Entity;


import javax.persistence.*;

@Entity
public class Book_Details {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookISBN;
    private String bookTitle;
    private String language;

    @OneToOne(cascade = CascadeType.ALL)
    private Book_Publications book_publications;

    private int noOfCopiesActual;
    private int noOfCopiesCurrent;
    private int publicationYear;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Book_Category book_Category;

    public int getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(int bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Book_Publications getBook_publications() {
        return book_publications;
    }

    public void setBook_publications(Book_Publications book_publications) {
        this.book_publications = book_publications;
    }

    public int getNoOfCopiesActual() {
        return noOfCopiesActual;
    }

    public void setNoOfCopiesActual(int noOfCopiesActual) {
        this.noOfCopiesActual = noOfCopiesActual;
    }

    public int getNoOfCopiesCurrent() {
        return noOfCopiesCurrent;
    }

    public void setNoOfCopiesCurrent(int noOfCopiesCurrent) {
        this.noOfCopiesCurrent = noOfCopiesCurrent;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Book_Category getBook_Category() {
        return book_Category;
    }

    public void setBook_Category(Book_Category book_Category) {
        this.book_Category = book_Category;
    }

    public Book_Details() {
        super();
    }

    public Book_Details(int bookISBN, String bookTitle, String language, Book_Publications book_publications, int noOfCopiesActual, int noOfCopiesCurrent, int publicationYear, Book_Category book_Category) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.language = language;
        this.book_publications = book_publications;
        this.noOfCopiesActual = noOfCopiesActual;
        this.noOfCopiesCurrent = noOfCopiesCurrent;
        this.publicationYear = publicationYear;
        this.book_Category = book_Category;
    }

    @Override
    public String toString() {
        return "Book_Details{" +
                "bookISBN=" + bookISBN +
                ", bookTitle='" + bookTitle + '\'' +
                ", language='" + language + '\'' +
                ", book_publications=" + book_publications +
                ", noOfCopiesActual=" + noOfCopiesActual +
                ", noOfCopiesCurrent=" + noOfCopiesCurrent +
                ", publicationYear=" + publicationYear +
                ", book_Category=" + book_Category +
                '}';
    }
}