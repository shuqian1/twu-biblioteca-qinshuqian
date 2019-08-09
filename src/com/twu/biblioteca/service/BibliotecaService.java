package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaService {

    static final String invalidMenuMessage = "Please select a valid option!";

    BookService bookService = new BookService();

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

    public void handleMenu(int selectId){
        switch (selectId){
            case 1:
                bookService.showAllBooks().forEach(System.out::println);
                break;
            default:
                System.out.println(invalidMenuMessage);
                break;
        }
    }

    public int handleSelect(){
        int selectId = -1;
        try {
            Scanner scanner = new Scanner(System.in);
            selectId = scanner.nextInt();
        }catch (Exception e){
            System.out.println(invalidMenuMessage);
        }
        return selectId;
    }
}
