package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BookService {
    ArrayList<Book> bookArrayList = new ArrayList<Book>(Arrays.asList(new Book("Who Moved My Cheese","Johnson","1999-03-04"),
            new Book("Flipped","Wendelin","2005-07-01"),
            new Book("The Catcher in the Rye","Salinger","1991-05-01")));

//    public ArrayList initBook(){
//        bookArrayList.add(new Book("Who Moved My Cheese","Johnson","1999-03-04"));
//        bookArrayList.add(new Book("Flipped","Wendelin","2005-07-01"));
//        bookArrayList.add(new Book("The Catcher in the Rye","Salinger","1991-05-01"));
//        return bookArrayList;
//    }

    public List showAllBooks(){
        List<String> books = bookArrayList.stream().filter(book -> !book.isCheckOut()).map(Book::getInfo).collect(Collectors.toList());
        return books;

    }



}
