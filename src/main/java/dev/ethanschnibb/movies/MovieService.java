package dev.ethanschnibb.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    //Have to first initialise this bit of code either with a constructor or can use @Autowired
    //Autowired lets framework know we want framework to instantiate this class
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){

        //findAll() defined within the MongoRepository class
        return movieRepository.findAll();
    }

    //find id method may not find any movie at all (id provided may not exist) - in this case return null - done with Optional before the Movie
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
