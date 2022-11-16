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
public class ActorsController {
    private List<Actor> actors = new ArrayList<>();
    {
        Actor actor1 = new Actor("Jason", "Statam", "26-07-1967");
        Actor actor2 = new Actor("Java", "De Brodway", "23-12-2005");
        Actor actor3 = new Actor("Michel", "Sardou", "26-07-1950");

        Movie movie1 = new Movie("En eau trouble", "Toto", null, 2008);
        Movie movie2 = new Movie("Transporteur 1", "Toto", null, 2001);
        Movie movie3 = new Movie("Transporteur 2", "Toto", null, 2010);
        List<Movie> buf = new ArrayList<Movie>();
        buf.add(movie1); buf.add(movie2); buf.add(movie3);
        actor1.setFilmographie(buf);

        movie1 = new Movie("Titi et grominet", "Toto", null, 2008);
        movie2 = new Movie("Spirou et Fantsio", "Toto", null, 2005);
        movie3 = new Movie("Star Trek", "Toto", null, 2022);
        buf = new ArrayList<Movie>();
        buf.add(movie1); buf.add(movie2); buf.add(movie3); buf.add(new Movie("Transporteur 2", "Toto", null, 2010));
        actor2.setFilmographie(buf);

        movie1 = new Movie("L'eleve ducobu", "Toto", null, 2030);
        movie2 = new Movie("Toto va a la plage", "Toto", null, 2010);
        movie3 = new Movie("Comment tricher", "Toto", null, 2001);
        buf = new ArrayList<Movie>();
        buf.add(movie1); buf.add(movie2); buf.add(movie3);
        actor3.setFilmographie(buf);

        actors.add(actor1); actors.add(actor2); actors.add(actor3); 
    }

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "Not Authorized"),
        @ApiResponse(code = 403, message = "Forbidden!"),
        @ApiResponse(code = 404, message = "Not Found")
    })

    @ApiOperation(
        value = "List the actors",
        response = Iterable.class,
        notes = "This method list all actors"
    )
    @GetMapping(value = "/actors")
    public List<Actor> getActors() {
        return actors;
    }

    @ApiOperation(
        value = "List the actors",
        response = Actor.class,
        notes = "This return a specific actor corresponding to the given lastname"
    )
    @GetMapping(value = "/actors/{nom}")
    public Actor getActorByNom(@PathVariable(value = "nom") String nom) {
        return actors.stream()
            .filter(actor -> actor.getNom().equals(nom))
            .findFirst().orElse(null);
    }

    @ApiOperation(
        value = "List the actors",
        response = Iterable.class,
        notes = "This method list all actors that has played in the specified movie"
    )
    @GetMapping(value = "/actors/in/{movie}")
    public List<Actor> getActorsInMovie(@PathVariable(value = "movie") String movie) {
        Movie movieObj = MoviesController.getMoviesList().stream()
            .filter(m -> m.getTitre().equals(movie))
            .findFirst().orElse(new Movie("", "", null, 0));
        
        System.out.println(movieObj.getTitre());

        return actors.stream()
            .filter(actor -> actor.getFilmographie().contains(movieObj))
            .collect(Collectors.toList());
    }
}
