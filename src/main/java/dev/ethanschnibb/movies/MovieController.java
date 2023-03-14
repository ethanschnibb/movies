package dev.ethanschnibb.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
//Instead of mapping to localhost 8080 - maps to /api/v1/movies
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    //Need a reference to our service class
    private MovieService movieService;
    
    @GetMapping
    //Difference in doing it like this rather than just returning a string is you can run it in cmd prompt with
    //curl -i http://localhost:8080/api/v1/movies 
    public ResponseEntity<List<Movie>> getAllMovies() {

        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    //Attempting to access a single movie
    @GetMapping("/{imdbId}")
    //This lets framework know, whatever we are getting through the path {id} - want to convert that to an objectid called id
    public ResponseEntity<Optional<Movie>> getSingleMove(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

}
