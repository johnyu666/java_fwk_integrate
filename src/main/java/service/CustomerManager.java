package service;

import java.util.List;

import pojo.Customer;

public interface CustomerManager {
	public Customer registCustomer(Customer c);
	public Customer updateCustomer(String id,Customer c);
	public void deleteCustomer(String id);
	public List<Customer> findAllCustomers();
}
