package com.movie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movie.dao.entity.CustomerEntity;
import com.movie.dao.entity.LoginEntity;

@Repository("LoginDao")
public class LoginDao implements ILoginDao {


	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public LoginEntity authUser(LoginEntity entity) {
		String fetch="select   * from login_auth_tbl where  username=? and password=?";
		Object data[]=new Object[]{entity.getUsername(),entity.getPassword()};
		LoginEntity loginEntity=new LoginEntity();
		try {
			 loginEntity=jdbcTemplate.queryForObject(fetch,data,new BeanPropertyRowMapper<LoginEntity>(LoginEntity.class));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return loginEntity;
	}


	@Override
	public String saveCustomer(CustomerEntity customerEntity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
