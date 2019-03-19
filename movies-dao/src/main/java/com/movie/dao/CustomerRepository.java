package com.movie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.movie.dao.entity.CustomerEntity;
import com.movie.dao.entity.LoginEntity;

/**
 * 
 * @author VC1
 * this is our interface no need to write implementation
 * implementation will be provided by the spring data
 *
 */
@Transactional(propagation=Propagation.REQUIRED)
@Repository
public interface CustomerRepository   extends CrudRepository<CustomerEntity, Integer>{

}
