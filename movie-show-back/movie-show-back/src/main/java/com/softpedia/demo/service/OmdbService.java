package com.softpedia.demo.service;

import com.softpedia.demo.dto.MovieDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OmdbService {

    @Value("${omdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<MovieDto> searchMovies(String title){
        String url = "https://www.omdbapi.com/?apikey=" + apiKey + "&s=" + title;
        Map<String, Object> result = restTemplate.getForObject(url, Map.class);
        if (result.containsKey("Search")) {
            List<Map<String, String>> movies = (List<Map<String, String>>) result.get("Search");
            return movies.stream().map(m -> {
                MovieDto dto = new MovieDto();
                dto.setImdbId(m.get("imdbID"));
                dto.setTitle(m.get("Title"));
                dto.setYear(m.get("Year"));
                dto.setPosterUrl(m.get("Poster"));
                dto.setPlot("");
                return dto;
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}