package com.softpedia.demo.service;

import com.softpedia.demo.dto.MovieDto;
import com.softpedia.demo.entity.Movie;
import com.softpedia.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie save(MovieDto movieDto){
        if (movieRepository.existsByImdbId(movieDto.getImdbId())){
            throw new RuntimeException("Movie already exists");
        }

        Movie movie = new Movie();
        movie.setImdbId(movieDto.getImdbId());
        movie.setTitle(movieDto.getTitle());
        movie.setYear(movieDto.getYear());
        movie.setPosterUrl(movieDto.getPosterUrl());
        movie.setPlot(movieDto.getPlot());

        return movieRepository.save(movie);
    }

    public void delete(Long id){
        movieRepository.deleteById(id);
    }

    public List<Movie> getAll(){
        return movieRepository.findAll();
    }
}
