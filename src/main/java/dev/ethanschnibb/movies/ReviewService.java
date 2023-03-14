package dev.ethanschnibb.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    //Associate the review with one of the movies - need a template to do this (better with complex implementations) - repository is another way to talk to the database
    //Templates form dynamic queries and do the job inside the database without using repositories
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Review createReview(String reviewBody, String imdbId) {

        //Insert a new review into the database - when insert is called it returns data that's just been pushed inside database
        Review review = reviewRepository.insert(new Review(reviewBody));
        

        //Update operation on Movie class to add the review to it
        //Using the template to perform an update call on Movie class - each movie in the collection contains an empty array of reviewIds
        mongoTemplate.update(Movie.class)
                //Updating a move where the imdbId of movie in database == imdbId received from the user
                .matching(Criteria.where("imdbId").is(imdbId))
                //Then apply this update - want to update the reviewIds in this found movie and the value of this movie is review
                .apply(new Update().push("reviewIds").value(review))
                //Makes sure we get a single movie
                .first();

        return review;
    }

    public List<Review> allReviews()
    {
        return reviewRepository.findAll();
    }
}
