package com.softpedia.demo.repository;

import com.softpedia.demo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    boolean existsByImdbId(String imdbId);
}