package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {

    public String printWelcomeMessage(){
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        return welcomeMessage;
    }


    public ArrayList<String> showMenuList(){
        ArrayList<String> menulist = new ArrayList<>();
        Menu listOfBooks = new Menu(1,"List of books");
        menulist.add(listOfBooks.toString());
        return menulist;
    }
}
