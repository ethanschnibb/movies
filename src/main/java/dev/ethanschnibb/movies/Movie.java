package dev.ethanschnibb.movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lets framework know this class presents each document in the moview collection
@Document(collection = "movies")
//Annotations that comes from the lombok project - takes care of all getters and setters and tostring methods
@Data
//Annotation for creating a constructor that takes the private fields as arguments
@AllArgsConstructor
//Constructor that takes no parameters
@NoArgsConstructor
public class Movie {

    @Id 
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    //Causes the database to store only the IDs of the review and the reviews will be in a separate collection - manual reference relationship
    @DocumentReference
    private List<Review> reviewIds;
    
}
