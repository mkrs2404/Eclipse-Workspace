package com.mohit.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.mohit.moviecatalogservice.models.CatalogItem;
import com.mohit.moviecatalogservice.models.Movie;
import com.mohit.moviecatalogservice.models.Rating;
import com.mohit.moviecatalogservice.models.UserRating;

@RequestMapping("/catalog")
@RestController
public class MovieCatalogResource {

	@Autowired
	RestTemplate restTemplate ;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
//		WebClient.Builder builder = WebClient.builder();
		
		//Hardcoding ratings-data-service response for now
//		List<Rating> ratings = Arrays.asList(
//				new Rating("1234",4),
//				new Rating("5678",3)
//				); 
		
		UserRating userRatings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
		List<Rating> ratings = userRatings.getRatings();
		return ratings.stream().map(rating -> {
			//For each movieId, call movie info service and get details
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//			Movie movie = builder.build()
//								   .get()
//								   .uri("http://localhost:8082/movies/" + rating.getMovieId())
//								   .retrieve()
//								   .bodyToMono(Movie.class)
//								   .block();
			
			return new CatalogItem(movie.getName(), "Desc", rating.getRating());
		})
		.collect(Collectors.toList());
		
	}
}
