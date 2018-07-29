package dao;

import java.util.List;


import pojo.Customer;

public interface CustomerDao {
	public Customer addCustomer(Customer c);
	public Customer updateCustomer(String id,Customer c);
	public void  deleteCustomer(String id);
	public List<Customer> findAllCustomers();
	
}
