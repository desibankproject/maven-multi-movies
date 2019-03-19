package com.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public interface LoginRepository   extends CrudRepository<LoginEntity, Integer>{

	 @Query("SELECT c FROM LoginEntity c WHERE c.username=:username and c.password=:password")
	   public LoginEntity authUser(@Param("username") String username,@Param("password") String password);
}
