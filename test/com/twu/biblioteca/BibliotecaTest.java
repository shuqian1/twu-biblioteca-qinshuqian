package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.BibliotecaService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BibliotecaTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final PrintStream printStream = System.out;

    @Before
    public void  setUpStream(){
        System.setOut((new PrintStream(outContent)));
    }

    @After
    public void restoreStream(){
        System.setOut(printStream);
    }

    @Test
    public void shouldPrintWelcomeMessage(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        assertThat(bibliotecaService.printWelcomeMessage(),equalTo("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void shouldShowAllBooks(){
        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        bookArrayList.add(new Book("Who Moved My Cheese","Johnson","1999-03-04"));
        bookArrayList.add(new Book("Flipped","Wendelin","2005-07-01"));
        bookArrayList.add(new Book("The Catcher in the Rye","Salinger","1991-05-01"));
        ArrayList<Book> actual = new ArrayList();
        assertThat(actual,equalTo(bookArrayList));
    }
}
