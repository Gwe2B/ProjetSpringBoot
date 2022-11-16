package com.gwe2b.mymovies.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gwe2b.mymovies.model.Actor;
import com.gwe2b.mymovies.model.Movie;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
public class MoviesController {
    private static List<Movie> movies = new ArrayList<>();
    public static List<Movie> getMoviesList() {
        return movies;
    }

    {
        Actor actor1 = new Actor("Jason", "Statam", "26-07-1967");
        Actor actor2 = new Actor("Java", "De Brodway", "23-12-2005");
        Actor actor3 = new Actor("Michel", "Sardou", "26-07-1950");

        Movie movie1 = new Movie("En eau trouble", "Toto", actor1, 2008);
        Movie movie2 = new Movie("Transporteur 1", "Toto", actor1, 2001);
        Movie movie3 = new Movie("Transporteur 2", "Toto", actor1, 2010);
        movies.add(movie1); movies.add(movie2); movies.add(movie3);

        movie1 = new Movie("Titi et grominet", "Toto", actor2, 2008);
        movie2 = new Movie("Spirou et Fantsio", "Toto", actor2, 2005);
        movie3 = new Movie("Star Trek", "Toto", actor2, 2022);
        movies.add(movie1); movies.add(movie2); movies.add(movie3);

        movie1 = new Movie("L'eleve ducobu", "Toto", actor3, 2030);
        movie2 = new Movie("Toto va a la plage", "Toto", actor3, 2010);
        movie3 = new Movie("Comment tricher", "Toto", actor3, 2001);
        movies.add(movie1); movies.add(movie2); movies.add(movie3);
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "Not Authorized"),
        @ApiResponse(code = 403, message = "Forbidden!"),
        @ApiResponse(code = 404, message = "Not Found")
    })

    @ApiOperation(
        value = "List the movies",
        response = Iterable.class,
        notes = "This method list all movies"
    )
    @GetMapping(value = "/movies")
    public List<Movie> getMovies() {
        return movies;
    }

    @ApiOperation(
        value = "List the movies",
        response = Movie.class,
        notes = "This method list the movie corresponding to the title"
    )
    @GetMapping(value = "/movies/{moviename}")
    public Movie getMovieByNom(@PathVariable(value = "moviename") String moviename) {
        return movies.stream()
            .filter(movie -> movie.getTitre().equals(moviename))
            .findFirst().orElse(null);
    }

    @ApiOperation(
        value = "List the movies",
        response = Iterable.class,
        notes = "This method list all the movies released within the specified year"
    )
    @GetMapping(value = "/movies/out/{sortie}")
    public List<Movie> getMovieBySortie(@PathVariable(value = "sortie") int sortie) {
        return movies.stream()
            .filter(movie -> movie.getSortie() == sortie)
            .collect(Collectors.toList());
    }
}
