package com.gwe2b.mymovies.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gwe2b.mymovies.model.Actor;
import com.gwe2b.mymovies.model.Movie;

@RestController
public class MoviesController {
    private List<Movie> movies = new ArrayList<>();
    private List<Actor> actors = new ArrayList<>();

    {
        Actor actor1 = new Actor("Jason", "Statam", "26-07-1967");
        Actor actor2 = new Actor("Java", "De Brodway", "23-12-2005");
        Actor actor3 = new Actor("Michel", "Sardou", "26-07-1950");

        Movie movie1 = new Movie("En eau trouble", "Toto", actor1, 2008);
        Movie movie2 = new Movie("Transporteur 1", "Toto", actor1, 2001);
        Movie movie3 = new Movie("Transporteur 2", "Toto", actor1, 2010);
        List<Movie> buf = new ArrayList<Movie>();
        buf.add(movie1); buf.add(movie2); buf.add(movie3);
        actor1.setFilmographie(buf);
        movies.add(movie1); movies.add(movie2); movies.add(movie3);

        movie1 = new Movie("Titi et grominet", "Toto", actor1, 2008);
        movie2 = new Movie("Spirou et Fantsio", "Toto", actor1, 2005);
        movie3 = new Movie("Star Trek", "Toto", actor1, 2022);
        buf = new ArrayList<Movie>();
        buf.add(movie1); buf.add(movie2); buf.add(movie3);
        actor2.setFilmographie(buf);
        movies.add(movie1); movies.add(movie2); movies.add(movie3);

        movie1 = new Movie("L'eleve ducobu", "Toto", actor1, 2030);
        movie2 = new Movie("Toto va a la plage", "Toto", actor1, 2010);
        movie3 = new Movie("Comment tricher", "Toto", actor1, 2001);
        buf = new ArrayList<Movie>();
        buf.add(movie1); buf.add(movie2); buf.add(movie3);
        actor3.setFilmographie(buf);
        movies.add(movie1); movies.add(movie2); movies.add(movie3);

        actors.add(actor1); actors.add(actor2); actors.add(actor3); 
    }

    
}
