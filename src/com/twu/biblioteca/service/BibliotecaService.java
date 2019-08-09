package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaService {

    static final String invalidMenuMessage = "Please select a valid option!";
    static final String successfulMessageCheckout = "Thank you!Enjoy the book";
    static final String unsuccessfulMessageCheckout = "Sorry,that book is not available";

    BookService bookService = new BookService();

    public String printWelcomeMessage(){
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        return welcomeMessage;
    }


    public ArrayList<String> showMenuList(){
        ArrayList<String> menulist = new ArrayList<>();
        Menu listOfBooks = new Menu(1,"List of books");
        Menu quitMenu = new Menu(0,"quit");
        menulist.add(quitMenu.toString());
        menulist.add(listOfBooks.toString());
        return menulist;
    }

    public void handleMenu(int selectId){
        switch (selectId){
            case 0:
                break;
            case 1:
                bookService.showAllBooks().forEach(System.out::println);
                break;
            default:
                System.out.println(invalidMenuMessage);
                break;
        }
    }

    public void handleCheckout(String s){

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

    public String handleInputString(){
        String s = "";
        try {
            Scanner scanner = new Scanner(System.in);
            s = scanner.next();
        }catch (Exception e){
            System.out.println(unsuccessfulMessageCheckout);
        }
        return s;
    }
}
