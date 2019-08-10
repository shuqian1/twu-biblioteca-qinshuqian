package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.User;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaService {

    static final String invalidMenuMessage = "Please select a valid option!";
    static final String errorInput = "Error input!";
    static final String successfulBookCheckout = "Thank you!Enjoy the book";
    static final String unsuccessfulBookCheckout = "Sorry,that book is not available";
    static final String successfulMessageReturn = "Thank you for returning the book";
    static final String unsuccessfulMessageReturn = "That is not a valid book to return";
    static final String bookListInfo = "title  ||  author  ||  publicationYear";
    static final String movieListInfo = "name  ||  year  ||  directo || ratingr";
    static final String successfulMovieCheckout = "Thank you!Enjoy the movie";
    static final String unsuccessfulMovieCheckout = "Sorry,that movie is not available";
    static final String loginFailMessage = "login failed";
    static final String checkoutRecordInfo = "title  ||  userId  ||  userName";


    BookService bookService = new BookService();

    MovieService movieService = new MovieService();

    LoginService loginService = new LoginService();

    MenuService menuService = new MenuService();

    BookCheckoutRecordService bookCheckoutRecordService = new BookCheckoutRecordService();

    public String printWelcomeMessage(){
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String loginMessage = "Please login.Input your userId and password,separate it with blank lines.";
        return welcomeMessage + "\r\n" + loginMessage;
    }

    public ArrayList<String> showMenuList(){
        ArrayList<String> menulist = new ArrayList<>();
        Menu listOfBooks = new Menu(1,"List of books");
        Menu quitMenu = new Menu(0,"quit");
        Menu checkoutMenu = new Menu(2,"checkout book");
        Menu returnMenu = new Menu(3,"return book");
        Menu movieMenu = new Menu(4,"List of Movies");
        Menu movieCheckout = new Menu(5,"checkout movie");
        menulist.add(quitMenu.toString());
        menulist.add(listOfBooks.toString());
        menulist.add(checkoutMenu.toString());
        menulist.add(returnMenu.toString());
        menulist.add(movieMenu.toString());
        menulist.add(movieCheckout.toString());
        return menulist;
    }

    public void login(){
        String id = "";
        String password = "";
        try {
            Scanner scanner = new Scanner(System.in);

            id = scanner.nextLine();
            password = scanner.nextLine();

        }catch (Exception e){
            System.out.println(errorInput);
        }
//        success
        if(loginService.login(id,password)){
            User user = loginService.getInfoById(id);
            printMenuList(user.getRole());
            handleMenu(handleSelect(),user);
        } else {
//            fail
            System.out.println(loginFailMessage);
            login();
        }
    }

    public void printMenuList(Role role){
        menuService.getMenuByRole(role).forEach(System.out::println);
        System.out.println("please input menuId:");
    }

    public void handleMenu(int selectId,User user){
        switch (selectId){
            case 0:
                break;
            case 9:
                break;
            case 1:
                System.out.println(bookListInfo);
                bookService.showAllBooks().forEach(System.out::println);
                printMenuList(user.getRole());
                handleMenu(handleSelect(),user);
                break;
            case 2:
                System.out.println("please input book's title:");
                System.out.println(handleCheckout(handleInputString()));
                printMenuList(user.getRole());
                handleMenu(handleSelect(),user);
                break;
            case 3:
                System.out.println("please input book's title:");
                System.out.println(handleReturn(handleInputString()));
                printMenuList(user.getRole());
                handleMenu(handleSelect(),user);
                break;
            case 4:
                System.out.println(movieListInfo);
                movieService.showMovies().forEach(System.out::println);
                printMenuList(user.getRole());
                handleMenu(handleSelect(),user);
                break;
            case 5:
                System.out.println("please input movie's name:");
                System.out.println(handleCheckoutMovie(handleInputString()));
                printMenuList(user.getRole());
                handleMenu(handleSelect(),user);
                break;
            case 6:
                System.out.println(checkoutRecordInfo);
                printCheckoutRecord();
                printMenuList(user.getRole());
                handleMenu(handleSelect(),user);
                break;
            default:
                System.out.println(invalidMenuMessage);
                printMenuList(user.getRole());
                handleMenu(handleSelect(),user);
                break;
        }
    }

    public String handleCheckout(String s){
        if(bookService.checkout(s)) {
            return successfulBookCheckout;
        } else{
            return unsuccessfulBookCheckout;
        }
    }

    public String handleReturn(String s){
        if(bookService.returnBook(s)){
            return successfulMessageReturn;
        } else {
            return unsuccessfulMessageReturn;
        }
    }

    public String handleCheckoutMovie(String s){
        if(movieService.checkout(s)){
            return successfulMovieCheckout;
        } else {
            return unsuccessfulMovieCheckout;
        }
    }

    public void printCheckoutRecord(){
        ArrayList<ArrayList> records = bookCheckoutRecordService.getCheckoutRecord();
        for (int i = 0;i<records.size();i++){
            ArrayList record = records.get(i);
            System.out.println(record.get(0) + "  ||  " + record.get(1) + "  ||  " + record.get(2));
        }
    }

    public int handleSelect(){
        int selectId = -1;
        try {
            Scanner scanner = new Scanner(System.in);
            selectId = scanner.nextInt();
        }catch (Exception e){
            System.out.println(errorInput);
        }
        return selectId;
    }

    public String handleInputString(){
        String s = "";
        try {
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();
        }catch (Exception e){
            System.out.println(errorInput);
        }
        return s;
    }
}
