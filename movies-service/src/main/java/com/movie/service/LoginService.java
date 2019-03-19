package com.movie.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.CustomerRepository;
import com.movie.dao.LoginRepository;
import com.movie.dao.entity.CustomerEntity;
import com.movie.dao.entity.LoginEntity;
import com.movie.model.Customer;
import com.movie.model.Login;

@Service("LoginService")
public class LoginService implements ILoginService {


	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	
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
		customerRepository.save(customerEntity);
		return "success";
	}
	
	@Override
	public Login authUser(Login login){
		LoginEntity pentity=new LoginEntity();
		BeanUtils.copyProperties( login, pentity);
		LoginEntity dloginEntity  =loginRepository.authUser(pentity.getUsername(),pentity.getPassword());
		Login dlogin=new Login();
		BeanUtils.copyProperties( dloginEntity, dlogin);
		return dlogin;
	}

}
