package com.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movie.dao.IMovieDao;
import com.movie.dao.entity.MovieEntity;
import com.movie.dao.entity.MovieType;
import com.movie.model.Movie;
import com.movie.model.Type;

@Service("MovieService")
public class MovieService implements IMovieService {

/*	@Autowired
	@Qualifier("MovieDao")
	private IMovieDao movieDao;*/
	

	@Autowired
	@Qualifier("MovieHibernateDao")
	private IMovieDao movieDao;
	
	

	@Override
	public String save(Movie movie) {
		MovieEntity entity=new MovieEntity();
		BeanUtils.copyProperties( movie, entity);
		String result=movieDao.save(entity);
		//String result=movieDao.save(entity);
		return result;
	}
	
	@Override
	public String update(Movie movie) {
		MovieEntity entity=new MovieEntity();
		BeanUtils.copyProperties( movie, entity);
		String result=movieDao.update(entity);
		return result;
	}
	
	@Override
	public void deleteMovieTypeByMtid(int mtid) {
		 movieDao.deleteMovieTypeByMtid(mtid);
	}
	@Override
	public int saveMovieType(int mid,String movieType) {
		MovieType cmovieType=new MovieType();
		cmovieType.setDescription("TODO");
		cmovieType.setName(movieType);
		//This is most important
		MovieEntity movieEntity  =movieDao.findMovieByMid(mid);
		cmovieType.setMovie(movieEntity);
		
		return movieDao.saveMovieType(cmovieType);
	}
	
	@Override
	public Type findMovieTypeByName(String name) {
		MovieType movieType  =movieDao.findMovieTypeByName(name);
		Type type=new Type();
		BeanUtils.copyProperties( movieType, type);
		return type;
	}

	@Override
	public List<Movie> findMovies() {
		List<MovieEntity> entities=movieDao.findMovies();
		List<Movie>  movies=new ArrayList<Movie>();
		for(MovieEntity entity:entities){
			Movie movie=new Movie();
			List<Type> types=new ArrayList<>();
			//Below loop is for internal list copy
			for(MovieType mt:entity.getMovieTypes()){
				Type type=new  Type();
				BeanUtils.copyProperties( mt, type);
				types.add(type);
			}
			BeanUtils.copyProperties( entity, movie);
			movie.setTypes(types);
			movies.add(movie);
		}
		return movies;
	}
	
	@Override
	public Movie findMovieByMid(int mid) {
	    	MovieEntity movieEntity  =movieDao.findMovieByMid(mid);
			Movie movie=new Movie();
			BeanUtils.copyProperties( movieEntity, movie);
		  return movie;
	}

	@Override
	public String deleteMovieByTitle(String title) {
		return movieDao.deleteMovieByTitle(title);
	}
	
	@Override
	public String deleteMovieByMid(int mid) {
		return movieDao.deleteMovieByMid(mid);
	}
	
	@Override
	public byte[] findImageByMid(int mid) {
		return movieDao.findImageByMid(mid);
	}


	@Override
	public List<Movie> findMoviesByTitle(String title) {
		List<MovieEntity> entities=movieDao.findMoviesByTitle(title);
		List<Movie>  movies=new ArrayList<Movie>();
		for(MovieEntity entity:entities){
			Movie movie=new Movie();
			BeanUtils.copyProperties( entity, movie);
			movies.add(movie);
		}
		return movies;
	}


	@Override
	// Java5 - Autoboxing and unboxing
	public int findMovieCount() {
		return movieDao.findMovieCount();
	}

}
