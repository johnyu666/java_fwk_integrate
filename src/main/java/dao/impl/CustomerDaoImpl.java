package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.CustomerDao;
import pojo.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	@PersistenceContext(name="em")
	private EntityManager manager;
	@Override
	public Customer addCustomer(Customer c) {
		manager.persist(c);
		return c;
	}

}
