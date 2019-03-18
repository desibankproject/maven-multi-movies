package com.jocker.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.movie.model.Movie;
import com.movie.service.IMovieService;

//@Controller is mandatory here
@Controller
public class MovieController {
	
	@Autowired   // ByType ->> @Qualifier ->>byName
	@Qualifier("MovieService")
	private IMovieService movieService;
	
	@GetMapping("/delete-movie-type")
	public String deleteMovieByType(@RequestParam("mtid") int mtid,Model model) {
		//This I forget to call...............
		movieService.deleteMovieTypeByMtid(mtid);
		List<Movie> searchResults=movieService.findMovies();
		//req.setAttribute("magicResults", searchResults);
		model.addAttribute("magicResults", searchResults);
		return "movies"; ///WEB-INF/views/movie.jsp
	}

	@PostMapping("/add-movie-type")
	public String addMovieType(@RequestParam("mid") int mid,@RequestParam("name") String movieType,Model model) {
		//This I forget to call...............
		movieService.saveMovieType(mid, movieType);
		/*List<Movie> searchResults=movieService.findMovies();
		//req.setAttribute("magicResults", searchResults);
		model.addAttribute("magicResults", searchResults);*/
		return "redirect:/movies"; ///
	}
	
	@GetMapping("/editMovie")
	public String editMovie(@RequestParam("mid") int mid,Model model) {
		//fetching movie data from the database using mid
		Movie  movie=movieService.findMovieByMid(mid);
		model.addAttribute("danger", movie);																									
		return "emovie"; ///movies
	}
	
	@GetMapping("/showPhoto")
	public void showPhoto(@RequestParam("mid") int mid,HttpServletResponse response) throws IOException {
		//@RequestParam("mid") int mid
		//String mid= req.getParameter("mid");
		//write  this byte[] into response so that I can reach to the browser
		  //Here We have to write very very very special code
		  response.setContentType("image/png");
		byte[] photo=movieService.findImageByMid(mid);
		//How to write byte[] directly response of incoming request
		ServletOutputStream outputStream=response.getOutputStream();
		if(photo!=null){
			outputStream.write(photo);
			outputStream.flush();
			outputStream.close();
		}
	}
	
	@GetMapping("/deleteMovie")
	public String deleteMovie(@RequestParam("mid") int mid,Model model) {
		//@RequestParam("mid") int mid
		//String mid= req.getParameter("mid");
		movieService.deleteMovieByMid(mid);
		//hey go to another action instead of jsp
		return "redirect:/movies"; ///movies
	}
	
	@GetMapping("/movies")
	public String showMovies(Model model){
		List<Movie> searchResults=movieService.findMovies();
		//req.setAttribute("magicResults", searchResults);
		model.addAttribute("magicResults", searchResults);
		return "movies"; ///WEB-INF/views/movie.jsp
	}
	
	
	@GetMapping("/movie")
	public String showMovie(Model model){
		Movie movie=new Movie();
		//Hey I am adding empty object inside request scope 
		movie.setTitle("Cool!!!!!!!!!!");
		model.addAttribute("movieCommand",movie);
		return "movie"; ///WEB-INF/views/movie.jsp
	}
	
	
	@GetMapping("/searchMovies")
	public String searchMovies(@RequestParam(value="title",required=false) String title,Model model){
		if(title!=null){
			List<Movie> movies=movieService.findMoviesByTitle(title);
			model.addAttribute("magicResults", movies);
		}
		return "search-movies"; ///WEB-INF/views/search-movies.jsp
	}
	
	@PostMapping("/updateMovie")
	public String updateMovie(@ModelAttribute Movie movie,Model model){
	  	   String hold= movieService.update(movie);
			//model is used to carry data from controller to jsp
			//it is similar to req.setAttribute("student", student);
	  	  return "redirect:/movies"; ///movies
	}
	
	@PostMapping("/addMovie")
	public String registeStudent(@ModelAttribute Movie movie,Model model){
		System.out.println(movie.getPhoto().toString());
		  String hold= movieService.save(movie);
		  return "msuccess"; //no need to write extension
	}
	
	@ModelAttribute("languageOptions")
	public List<String> languageOptions(){
		List<String> languageOptions=new ArrayList<String>();
		languageOptions.add("Hindi");
		languageOptions.add("English");
		languageOptions.add("Chinese");
		languageOptions.add("Purgal");
		return languageOptions;
	}
	
	
	@ModelAttribute("yearOptions")
	public List<String> loadYears(){
		List<String> options=new ArrayList<String>();
		options.add("2018");
		options.add("2019");
		options.add("2020");
		options.add("2021");
		options.add("2022");
		options.add("2023");
		options.add("2024");
		return options;
	}
	
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			// to actually be able to convert Multipart instance to byte[]
			// we have to register a custom editor
			binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
			// now Spring knows how to handle multipart object and convert them
		}

}
