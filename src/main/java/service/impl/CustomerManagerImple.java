package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;
import dao.CustomerDao;
import dao.ItemDao;
import pojo.Customer;
import service.CustomerManager;

@Service
public class CustomerManagerImple implements CustomerManager{
	
	@Autowired
	private CustomerDao customerDao;
	@Transactional
	@Override
	public Customer registCustomer(Customer c) {
		return customerDao.addCustomer(c);
	}

}
