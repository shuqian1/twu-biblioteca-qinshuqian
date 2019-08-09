package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.service.BibliotecaService;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> books = bookArrayList.stream().map(Book::getInfo).collect(Collectors.toList());
        BookService bookService = new BookService();
        List actual = bookService.showAllBooks();
        assertThat(actual,equalTo(books));
    }

    @Test
    public void shouldShowMenuList(){
        ArrayList<Menu> menuList = new ArrayList<>();
        Menu menu = new Menu(1,"List of books");
        menuList.add(menu);
        BibliotecaService bibliotecaService = new BibliotecaService();
        assertThat(bibliotecaService.showMenuList(),equalTo(menuList.stream().map(Menu::toString).collect(Collectors.toList())));
    }

    @Test
    public void shouldShowInvalidMessage(){
        int selectId = 8;
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.handleMenu(selectId);
        assertThat(outContent.toString(),equalTo("Please select a valid option!\r\n"));
    }

    @Test
    public void shouldQuit(){
        int selectId = 0;
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.handleMenu(selectId);
        assertThat(outContent.toString(),equalTo(""));
    }

    @Test
    public void shouldShowSuccessfulMessageOnCheckoutBook(){
        String rightBookName = "Flipped";
        BibliotecaService bibliotecaService = new BibliotecaService();
        assertThat( bibliotecaService.handleCheckout(rightBookName),equalTo("Thank you!Enjoy the book"));
    }

    @Test
    public void shouldShowUnsuccessfulMessageOnCheckoutBook(){
        String wrongBookName = "abc";
        BibliotecaService bibliotecaService = new BibliotecaService();
        assertThat(bibliotecaService.handleCheckout(wrongBookName),equalTo("Sorry,that book is not available"));
    }


    @Test
    public void houldShowSuccessfulMessageOnReturn(){
        String rightBookName = "The Catcher in the Rye";
        BibliotecaService bibliotecaService = new BibliotecaService();
        assertThat(bibliotecaService.handleReturn(rightBookName),equalTo("Thank you for returning the book"));
    }

    @Test
    public void shouldShowUnsuccessfulMessageOnReturn(){
        String wrongBookName1 = "aaa";
        String wrongBookName2 = "Flipped";
        BibliotecaService bibliotecaService = new BibliotecaService();
        assertThat(bibliotecaService.handleReturn(wrongBookName1),equalTo("That is not a valid book to return"));
        assertThat(bibliotecaService.handleReturn(wrongBookName2),equalTo("That is not a valid book to return"));
    }

    @Test
    public void shouldShowMovies(){
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Roman Holiday","1953","Willi Wyler",1));
        movies.add(new Movie("Forrester Gump","1994","Robert Lee Zemeckis",2));
        movies.add(new Movie("Titanic","1997","James Cameron",4));
        ArrayList movieList = (ArrayList) movies.stream().map(Movie::toString).collect(Collectors.toList());
        MovieService movieService = new MovieService();
        assertThat(movieService.showMovies(),equalTo(movieList));
    }

    @Test
    public void shouldShowSuccessfulMessageOnCheckoutMovie(){
        String rightMovieName = "Roman Holiday";
        BibliotecaService bibliotecaService = new BibliotecaService();
        assertThat( bibliotecaService.handleCheckoutMovie(rightMovieName),equalTo("Thank you!Enjoy the movie"));
    }

    @Test
    public void shouldShowUnsuccessfulMessageOnCheckoutMovie(){
        String wrongMovieName = "ff";
        BibliotecaService bibliotecaService = new BibliotecaService();
        assertThat(bibliotecaService.handleCheckout(wrongMovieName),equalTo("Sorry,that movie is not available"));
    }

}
