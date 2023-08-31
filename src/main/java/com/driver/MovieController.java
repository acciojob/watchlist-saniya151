package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    //1
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity("success", HttpStatus.FOUND);
    }
    //2
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity("success", HttpStatus.FOUND);
    }
    //3
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("mName") String mName,@RequestParam("dName") String dName)
    {
        movieService.addMovieDirectorPair(mName,dName);
        return new ResponseEntity("success", HttpStatus.FOUND);
    }
    //4
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name)
    {
        Movie m = movieService.getMovieByName(name);
        if(m == null)
        {
            return new ResponseEntity("Movie Not Found",HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity(m,HttpStatus.FOUND);
    }
    //5
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name)
    {
        Director d = movieService.getDirectorByName(name);
        if(d == null)
        {
            return new ResponseEntity("Director Not Found",HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity(d,HttpStatus.FOUND);
    }
    //6
    @GetMapping("/get-movies-by-director-name/{dName}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("dName") String dName)
    {
        List list = movieService.getMoviesByDirectorName(dName);
        if(list == null)
        {
            return new ResponseEntity("Director Name List Not Found",HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity(list,HttpStatus.FOUND);
    }
    //7
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies()
    {
        List list =  movieService.findAllMovies();
        if(list == null)
        {
            return new ResponseEntity("Movies Not Found",HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity(list,HttpStatus.FOUND);
    }
    //8
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("dName") String dName)
    {
        movieService.deleteDirectorByName(dName);
        return new ResponseEntity("success", HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity("success", HttpStatus.FOUND);
    }
}