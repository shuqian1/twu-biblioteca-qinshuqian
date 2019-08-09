package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;

public class BookService {

    public ArrayList initBook(){
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        bookArrayList.add(new Book("Who Moved My Cheese","Johnson","1999-03-04"));
        bookArrayList.add(new Book("Flipped","Wendelin","2005-07-01"));
        bookArrayList.add(new Book("The Catcher in the Rye","Salinger","1991-05-01"));
        return bookArrayList;
    }



}
