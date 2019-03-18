package com.movie.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.movie.dao.ILoginDao;
import com.movie.dao.entity.CustomerEntity;
import com.movie.dao.entity.LoginEntity;
import com.movie.model.Customer;
import com.movie.model.Login;

@Service("LoginService")
public class LoginService implements ILoginService {

/*	@Autowired
	@Qualifier("LoginDao")
	private ILoginDao loginDao;*/

	@Autowired
	@Qualifier("LoginHibernateDao")
	private ILoginDao loginDao;
	
	@Override
	public String saveCustomer(Customer customer) {
		Timestamp timestamp=new Timestamp(new Date().getTime());
		CustomerEntity customerEntity=new CustomerEntity();
		customerEntity.setEmail(customer.getEmail());
		customerEntity.setName(customer.getName());
		customerEntity.setMobile(customer.getMobile());
		customerEntity.setDoe(timestamp);
		
		LoginEntity loginEntity=new LoginEntity();
		loginEntity.setDoe(timestamp);
		loginEntity.setPassword(customer.getPassword());
		loginEntity.setUsername(customer.getUsername());
		loginEntity.setRole("admin");
		
		//This is very very important
		customerEntity.setLoginEntity(loginEntity);
		
		return loginDao.saveCustomer(customerEntity);
	}
	
	@Override
	public Login authUser(Login login){
		LoginEntity pentity=new LoginEntity();
		BeanUtils.copyProperties( login, pentity);
		LoginEntity dloginEntity  =loginDao.authUser(pentity);
		Login dlogin=new Login();
		BeanUtils.copyProperties( dloginEntity, dlogin);
		return dlogin;
	}

}
