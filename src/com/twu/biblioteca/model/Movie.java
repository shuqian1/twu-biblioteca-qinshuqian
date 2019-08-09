package com.twu.biblioteca.model;

public class Movie {
    private String name;
    private String year;
    private String director;
    private int rating;
    private boolean isCheckOut = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }

    public void setCheckOut(boolean checkOut) {
        isCheckOut = checkOut;
    }

    public Movie(String name, String year, String director, int rating, boolean isCheckOut) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isCheckOut = isCheckOut;
    }

    public Movie(String name, String year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + "  ||  " + year + "  ||  " + director + "  ||  " + rating;
    }
}
