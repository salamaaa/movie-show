package com.softpedia.demo.controller;


import com.softpedia.demo.dto.MovieDto;
import com.softpedia.demo.entity.Movie;
import com.softpedia.demo.service.MovieService;
import com.softpedia.demo.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")

public class AdminController {

    private final OmdbService omdbService;
    private final MovieService movieService;

    public AdminController(OmdbService omdbService, MovieService movieService) {
        this.omdbService = omdbService;
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public List<MovieDto> searchMovies(@RequestParam String title) {
        return omdbService.searchMovies(title);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMovie(@RequestBody MovieDto dto) {
        return ResponseEntity.ok(movieService.save(dto));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }
}
