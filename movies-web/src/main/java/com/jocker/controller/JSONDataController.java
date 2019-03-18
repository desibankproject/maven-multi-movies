package com.jocker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.movie.model.ApplicationResponse;
import com.movie.model.Movie;
import com.movie.service.IMovieService;

import io.swagger.annotations.Api;

@Controller
@Api(value="JSONDataController",description="Why this is here!")
public class JSONDataController {

	@Autowired   // ByType ->> @Qualifier ->>byName
	@Qualifier("MovieService")
	private IMovieService movieService;
	
	   @GetMapping("/fact/json")
		@ResponseStatus(value=HttpStatus.OK)
	   @ResponseBody	public ApplicationResponse  calFact(@RequestParam("num") int num){
				ApplicationResponse applicationResponse=new ApplicationResponse();
				int sum=1;
				for(int x=2;x<=num;x++){
					sum=sum*x;
				}
				applicationResponse.setNum(num);
				applicationResponse.setResult(sum);
				applicationResponse.setStatus("success");
				return applicationResponse;	
		}
	 
	   @GetMapping("/delete/movie")
	   @ResponseBody	public ApplicationResponse  deleteMovie(@RequestParam("mid") int mid){
		 		movieService.deleteMovieByMid(mid);
		 		ApplicationResponse applicationResponse=new ApplicationResponse();
				applicationResponse.setMessage("Hey! your movie is delete successfully from the database!");
				applicationResponse.setStatus("success");
				return applicationResponse;	
		}
	   
	   //@RequestBody - it takes raw data from request body and converts into Java Object
	   //@ResponseBody - it is converting Java Object into raw data and writing into response body
	   @PostMapping("/movies/json")
	   @ResponseBody	public ApplicationResponse uploadMovie(@RequestBody Movie movie){
			movieService.save(movie);
			ApplicationResponse applicationResponse=new ApplicationResponse();
			applicationResponse.setMessage("Hey! your movie is delete successfully from the database!");
			applicationResponse.setStatus("success");
			return applicationResponse;	
		}
	
	@GetMapping("/movies/json")
   @ResponseBody	public List<Movie> showMoviesAsJson(){
		List<Movie> searchResults=movieService.findMovies();
		return searchResults;
	}
}
