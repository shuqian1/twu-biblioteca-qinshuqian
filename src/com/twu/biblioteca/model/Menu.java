package com.twu.biblioteca.model;

import java.util.ArrayList;

public class Menu {
    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number + ":" + name;
    }

}
