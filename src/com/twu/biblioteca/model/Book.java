package com.twu.biblioteca.model;

import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;

public class Book {
    private String title;
    private String author;
    private String publicationYear;
    private boolean isCheckOut = false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }

    public void setCheckOut(boolean checkOut) {
        isCheckOut = checkOut;
    }

    public Book() {
    }

    public Book(String title, String author, String publicationYear, boolean isCheckOut) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isCheckOut = isCheckOut;
    }

    public Book(String title, String author, String publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getInfo(){
        return title + "  " + author + "  " + publicationYear;
    }
}


