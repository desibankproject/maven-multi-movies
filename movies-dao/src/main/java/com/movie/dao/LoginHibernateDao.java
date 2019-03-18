package com.movie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.movie.dao.entity.CustomerEntity;
import com.movie.dao.entity.LoginEntity;


@Repository("LoginHibernateDao")
@Transactional(value="hibernateTxManager")
public class LoginHibernateDao implements ILoginDao {


	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String saveCustomer(CustomerEntity customerEntity){
		getSession().save(customerEntity);
		return "success";
	}
	
	@Override
	public LoginEntity authUser(LoginEntity entity) {
		Query<LoginEntity> query=getSession().createQuery("from  LoginEntity as t where t.username=:pusername and t.password=:ppassword"); //HQL
		query.setParameter("pusername", entity.getUsername());
		query.setParameter("ppassword", entity.getPassword());
		 List<LoginEntity> loginEntities=query.list();
		 LoginEntity dloginEntity=new LoginEntity();
		 if(loginEntities.size()==1){
			 dloginEntity=loginEntities.get(0);
		 }
		return dloginEntity;
	}
	
}
