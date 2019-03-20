package com.movies.service;

import com.movies.model.Customer;
import com.movies.model.Login;

public interface ILoginService {

	Login authUser(Login login);

	String saveCustomer(Customer customer);

}
