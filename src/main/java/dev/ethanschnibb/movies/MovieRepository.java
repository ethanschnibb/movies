package dev.ethanschnibb.movies;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //Automatic querie - optional used as it may return null
    Optional<Movie> findMovieByImdbId(String imdbId);
}
