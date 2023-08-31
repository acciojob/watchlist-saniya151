package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String mName, String dName) {
        movieRepository.addMovieDirectorPair(mName,dName);
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public List getMoviesByDirectorName(String dName) {
        return movieRepository.getMoviesByDirectorName(dName);
    }

    public List findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String dName) {
        movieRepository.deleteDirectorByName(dName);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}