package com.movies.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.movies.dao.entity.MovieType;

@Transactional(propagation=Propagation.REQUIRED)
@Repository
//Integer -primary key of entity
public interface MovieTypeRepository   extends CrudRepository<MovieType, Integer>{
	public  MovieType  findByName(String name);
}




