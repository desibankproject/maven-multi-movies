package com.movies.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.movies.dao.entity.MovieEntity;

/**
 * 
 * @author VC1
 * this is our interface no need to write implementation
 * implementation will be provided by the spring data
 *
 */
@Transactional(propagation=Propagation.REQUIRED)
@Repository
//Integer -primary key of entity
public interface MoviesRepository   extends CrudRepository<MovieEntity, Integer>{

	 @Query("delete from MovieEntity m where m.title = ?1")
	public  void deleteMovieByTitle(String title);
	public  List<MovieEntity> findByTitle(String title);
}
