package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieService {
    ArrayList movieList = new ArrayList<>(Arrays.asList(new Movie("Roman Holiday","1953","Willi Wyler",1),
            new Movie("Forrester Gump","1994","Robert Lee Zemeckis",2),
            new Movie("The Shawshank Redemption","1994","Frank A. Darabont",3,true),
            new Movie("Titanic","1997","James Cameron",4)));

    public ArrayList showMovies(){
        return new ArrayList();
    }
}
