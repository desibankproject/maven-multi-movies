package com.movie.service;

import java.util.List;

import com.movie.model.Movie;
import com.movie.model.Type;

public interface IMovieService {

	public String save(Movie movie);
	public  List<Movie> findMovies();
	public String deleteMovieByTitle(String title);
	public List<Movie> findMoviesByTitle(String title);
	public int findMovieCount();
	public String deleteMovieByMid(int mid);
	public Movie findMovieByMid(int mid);
	public String update(Movie movie);
	byte[] findImageByMid(int mid);
	int  saveMovieType(int mid, String movieType);
	void deleteMovieTypeByMtid(int mtid);
	Type findMovieTypeByName(String name);

}
