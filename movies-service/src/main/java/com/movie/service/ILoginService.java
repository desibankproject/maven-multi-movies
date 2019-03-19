package com.movie.service;

import com.movie.model.Customer;
import com.movie.model.Login;

public interface ILoginService {

	Login authUser(Login login);

	String saveCustomer(Customer customer);

}
