package com.movie.dao;

import java.util.List;

import com.movie.dao.entity.MovieEntity;
import com.movie.dao.entity.MovieType;

public interface IMovieDao {
	public String save(MovieEntity entity);
	public List<MovieEntity> findMovies();
	public String deleteMovieByTitle(String title);
	public List<MovieEntity> findMoviesByTitle(String title);
	public int  findMovieCount();
	public String deleteMovieByMid(int mid);
	public MovieEntity findMovieByMid(int mid);
	public String update(MovieEntity entity);
	byte[] findImageByMid(int mid);
	default int saveMovieType(MovieType movieType){
		return 0;
	}
	default void deleteMovieTypeByMtid(int mtid){
	}
	default MovieType findMovieTypeByName(String name){
		return null;
	}
}
