package dev.ethanschnibb.movies;

//SpringApplication contains a method called run - to start spring application have to call this run method and pass your application class to it
// - can also pass some command line arguments to it (not going to do this here)
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//Imports spring boot application annotation - in java annotations used to let the compiler know anout what the class does
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//Annotation that lets framework know that this class is a REST API - and not just another class
//@RestController - tied in with @GetMapping method that we are not going to use here
public class MoviesApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	// //GetMapping lets the framework know that this method (apiRoot) is a GET endpoint
	// @GetMapping("/root")
	// public String apiRoot() {
	// 	return "Hello world";
	// } NOT GOING TO RUN THIS CODE - JUST AN EXAMPLE TO CHECK THE API IS WORKING CORRECTLY

}
