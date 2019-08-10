package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    ArrayList<Movie> movieList = new ArrayList<>(Arrays.asList(new Movie("Roman Holiday","1953","Willi Wyler",1),
            new Movie("Forrester Gump","1994","Robert Lee Zemeckis",2),
            new Movie("The Shawshank Redemption","1994","Frank A. Darabont",3,true),
            new Movie("Titanic","1997","James Cameron",4)));

    public ArrayList showMovies(){
        ArrayList<String> movieAvailable = (ArrayList<String>) movieList.stream().filter(movie -> !movie.isCheckOut()).map(Movie::toString).collect(Collectors.toList());
        return movieAvailable;
    }

    public boolean checkout(String name){
        List<Movie> movies = findByName(name);
        if(movies.size() == 0){
            return false;
        } else {
            Movie movie = movies.get(0);
            movie.setCheckOut(true);
            return true;
        }
    }

    public List<Movie> findByName(String name){
        List<Movie> movies =  movieList.stream().filter(movie -> movie.getName().equals(name)).filter(movie -> !movie.isCheckOut()).collect(Collectors.toList());
        return movies;
    }
}
