package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.CustomerDao;
import pojo.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext(name = "em")
	private EntityManager manager;

	@Override
	public Customer addCustomer(Customer c) {
		manager.persist(c);
		return c;
	}

	@Override
	public Customer updateCustomer(String id, Customer c) {
		c.setId(id);
		Customer c1 = manager.merge(c);
		return c1;
	}

	@Override
	public void deleteCustomer(String id) {
		Customer c = manager.getReference(Customer.class, id);
		manager.remove(c);
	}

	@Override
	public List<Customer> findAllCustomers() {
		String jpql="from Customer";
		return manager.createQuery(jpql).getResultList();
	}

}
