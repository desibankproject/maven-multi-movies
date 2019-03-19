package com.movie.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.ApplicationResponse;
import com.movie.model.Movie;
import com.movie.model.Type;
import com.movie.service.IMovieService;

/**
 * 
 * @author Nagendra
 * 
 */
@RestController
@RequestMapping("/v3/movies")
public class MoviesRestController {
	
	@Autowired   // ByType ->> @Qualifier ->>byName
	@Qualifier("MovieService")
	private IMovieService movieService;
	
	//METHOD=DELETE
	//http://localhost:4554/movies-spring-jdbc/v3/movies/types/9882
	@DeleteMapping("/types/{kkmtid}")
	public ApplicationResponse deleteMovieByType(@PathVariable("kkmtid") int mtid) {
		//This I forget to call...............
		movieService.deleteMovieTypeByMtid(mtid);
		ApplicationResponse applicationResponse=new ApplicationResponse();
		applicationResponse.setStatus("success");
		applicationResponse.setMessage("Hey! your resource  is deleted successfully.............. ");
		return applicationResponse;
	}
	
	///METHOD= POST
	///http://localhost:4554/movies-spring-jdbc/v3/movies/types
	@PostMapping("/types")
	public ApplicationResponse addMovieType(@RequestBody MovieTypeVO movieType) {
		ApplicationResponse applicationResponse=new ApplicationResponse();
		Type type=movieService.findMovieTypeByName(movieType.getName());
		if(type.getMtid()==0) {
			//This I forget to call...............
			int mtid=movieService.saveMovieType(movieType.getMid(), movieType.getName());
			applicationResponse.setNum(mtid);
			applicationResponse.setMessage("Hey! your resource  is deleted successfully.............. ");
			applicationResponse.setStatus("success");
		}else{
			applicationResponse.setMessage("Hey! this movie type already exist for this movie......... ");
			applicationResponse.setStatus("fail");
		}
		return applicationResponse;
	}
	
	
	
	@GetMapping
	public List<Movie> showMovies(){
		List<Movie> searchResults=movieService.findMovies();
		return searchResults;
	}
	
}
