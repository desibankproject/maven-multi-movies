package com.movie.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.movie.dao.entity.CustomerEntity;
import com.movie.dao.entity.MovieEntity;

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

}
