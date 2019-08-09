package com.twu.biblioteca;

import com.twu.biblioteca.service.BibliotecaService;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaService bibliotecaService = new BibliotecaService();
//        printWelcomeMessage
        System.out.println(bibliotecaService.printWelcomeMessage());
    }
}
