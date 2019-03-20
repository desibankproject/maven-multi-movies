package com.movies.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.dao.MovieTypeRepository;
import com.movies.dao.MoviesRepository;
import com.movies.dao.entity.MovieEntity;
import com.movies.dao.entity.MovieType;
import com.movies.model.Movie;
import com.movies.model.Type;

@Service("MovieService")
public class MovieService implements IMovieService {

/*	@Autowired
	@Qualifier("MovieDao")
	private IMovieDao movieDao;*/
	

/*	@Autowired
	@Qualifier("MovieHibernateDao")
	private IMovieDao movieDao;*/
	
	@Autowired
	private MoviesRepository moviesRepository;
	
	@Autowired
	private MovieTypeRepository movieTypeRepository;
	

	@Override
	public String save(Movie movie) {
		MovieEntity entity=new MovieEntity();
		BeanUtils.copyProperties( movie, entity);
		moviesRepository.save(entity);
		//String result=movieDao.save(entity);
		return "success";
	}
	
	@Override
	public String update(Movie movie) {
		MovieEntity entity=new MovieEntity();
		BeanUtils.copyProperties( movie, entity);
		moviesRepository.save(entity);
		return "success";
	}
	
	@Override
	public void deleteMovieTypeByMtid(int mtid) {
		moviesRepository.deleteById(mtid);
	}
	@Override
	public int saveMovieType(int mid,String movieType) {
		MovieType cmovieType=new MovieType();
		cmovieType.setDescription("TODO");
		cmovieType.setName(movieType);
		//This is most important
		Optional<MovieEntity>  optional  =moviesRepository.findById(mid);
		cmovieType.setMovie(optional.get());
		MovieType movieType2=movieTypeRepository.save(cmovieType);
		return movieType2.getMtid();
	}
	
	@Override
	public Type findMovieTypeByName(String name) {
		MovieType movieType  =movieTypeRepository.findByName(name);
		Type type=new Type();
		BeanUtils.copyProperties( movieType, type);
		return type;
	}

	@Override
	public List<Movie> findMovies() {
		Iterator<MovieEntity>  it=moviesRepository.findAll().iterator();
		List<Movie>  movies=new ArrayList<Movie>();
		while(it.hasNext()){
			MovieEntity entity=it.next();
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
	    	Optional<MovieEntity> optional  =moviesRepository.findById(mid);
			Movie movie=new Movie();
			BeanUtils.copyProperties( optional.get(), movie);
		  return movie;
	}

	@Override
	public String deleteMovieByTitle(String title) {
		 moviesRepository.deleteMovieByTitle(title);
		 return "success";
	}	
	
	@Override
	public String deleteMovieByMid(int mid) {
		 moviesRepository.deleteById(mid);
		 return "success";
	}
	
	@Override
	public byte[] findImageByMid(int mid) {
		return moviesRepository.findById(mid).get().getPhoto();
	}


	@Override
	public List<Movie> findMoviesByTitle(String title) {
		List<MovieEntity> entities=moviesRepository.findByTitle(title);
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
		return (int)moviesRepository.count();
	}

}
