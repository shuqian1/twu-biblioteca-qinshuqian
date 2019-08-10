package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuService {
    ArrayList<Menu> menuList = new ArrayList<>(Arrays.asList(new Menu(0,"Customer Quit",Role.Customer),
            new Menu(1,"List of Books", Role.Customer),
            new Menu(2,"Checkout Book",Role.Customer),
            new Menu(3,"Return Book",Role.Customer),
            new Menu(4,"List of Movies",Role.Customer),
            new Menu(5,"Checkout Movie",Role.Customer),
            new Menu(6,"List of Checkout Books",Role.Librarian),
            new Menu(9,"Librarian Quit",Role.Librarian)));

    public List<String> getMenuByRole(Role role){
        List<String> roleMenu = menuList.stream().filter(menu -> menu.getRole().equals(role)).map(Menu::toString).collect(Collectors.toList());
        return roleMenu;
    }
}
