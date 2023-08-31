package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    Map<String,Movie> hm = new HashMap<>();
    Map<String,Director> hm1 = new HashMap<>();
    Map<String,List> hm2 = new HashMap<>();

    public void addMovie(Movie movie) {
        hm.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        hm1.put(director.getName(),director);
    }

    public void addMovieDirectorPair(String mName, String dName) {
        List<String> mList = new ArrayList<>();
        List<String> dList = new ArrayList<>();
        mList.add(dName);
        dList.add(mName);

        if(hm2.containsKey(mName))
        {
            hm2.get(mName).add(dName);
        }
        else hm2.put(mName,mList);

        if(hm2.containsKey(dName))
        {
            hm2.get(dName).add(mName);
        }
        else hm2.put(dName,dList);

    }
    public Movie getMovieByName(String name) {
        return hm.get(name);
    }

    public Director getDirectorByName(String name) {
        return hm1.get(name);
    }

    public List getMoviesByDirectorName(String dName) {
        return hm2.get(dName);
    }

    public List findAllMovies() {
        List<String> list = new ArrayList<>();
        for(String mName : hm.keySet())
        {
            list.add(mName);
        }
        return list;
    }

    public void deleteDirectorByName(String dName) {
        List<String> list = hm2.get(dName);
        for(String mo : list)
        {
            List<String> list1 = hm2.get(mo);
            list1.remove(dName);
            if(list1.isEmpty())
            {
                hm2.remove(mo);
            }
        }
        hm2.remove(dName);
    }

    public void deleteAllDirectors() {
        hm.clear();
        hm1.clear();
    }
}