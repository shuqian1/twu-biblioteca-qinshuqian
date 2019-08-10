package com.twu.biblioteca;

import com.twu.biblioteca.service.BibliotecaService;
import com.twu.biblioteca.service.BookService;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        BookService bookService = new BookService();
//        printWelcomeMessage
        System.out.println(bibliotecaService.printWelcomeMessage());

//        bibliotecaService.printMenuList();
        bibliotecaService.login();

//        int selectId = bibliotecaService.handleSelect();
//        bibliotecaService.handleMenu(selectId);
//        bookService.showAllBooks().forEach(System.out::println);

    }
}
