package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaService {

    static final String invalidMenuMessage = "Please select a valid option!";
    static final String successfulMessageCheckout = "Thank you!Enjoy the book";
    static final String unsuccessfulMessageCheckout = "Sorry,that book is not available";
    static final String successfulMessageReturn = "Thank you for returning the book";
    static final String unsuccessfulMessageReturn = "That is not a valid book to return";
    static final String bookListInfo = "title  ||  author  ||  publicationYear";

    BookService bookService = new BookService();

    public String printWelcomeMessage(){
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        return welcomeMessage;
    }


    public ArrayList<String> showMenuList(){
        ArrayList<String> menulist = new ArrayList<>();
        Menu listOfBooks = new Menu(1,"List of books");
        Menu quitMenu = new Menu(0,"quit");
        Menu checkoutMenu = new Menu(2,"checkout");
        Menu returnMenu = new Menu(3,"return");
        Menu movieMenu = new Menu(4,"List of Movies");
        menulist.add(quitMenu.toString());
        menulist.add(listOfBooks.toString());
        menulist.add(checkoutMenu.toString());
        menulist.add(returnMenu.toString());
        return menulist;
    }

    public void printMenuList(){
        showMenuList().forEach(System.out::println);
        System.out.println("please input menuId:");
    }

    public void handleMenu(int selectId){
        switch (selectId){
            case 0:
                break;
            case 1:
                System.out.println(bookListInfo);
                bookService.showAllBooks().forEach(System.out::println);
                printMenuList();
                handleMenu(handleSelect());
                break;
            case 2:
                System.out.println("please input book title:");
                System.out.println(handleCheckout(handleInputString()));
                printMenuList();
                handleMenu(handleSelect());
                break;
            case 3:
                System.out.println("please input book title:");
                System.out.println(handleReturn(handleInputString()));
                printMenuList();
                handleMenu(handleSelect());
                break;
            default:
                System.out.println(invalidMenuMessage);
                printMenuList();
                handleMenu(handleSelect());
                break;
        }
    }

    public String handleCheckout(String s){
        if(bookService.checkout(s)) {
            return successfulMessageCheckout;
        } else{
            return unsuccessfulMessageCheckout;
        }
    }

    public String handleReturn(String s){
        if(bookService.returnBook(s)){
            return successfulMessageReturn;
        } else {
            return unsuccessfulMessageReturn;
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

    public String handleInputString(){
        String s = "";
        try {
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();
        }catch (Exception e){
            System.out.println(unsuccessfulMessageCheckout);
        }
        return s;
    }
}
