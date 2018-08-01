package controller;

import java.lang.invoke.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pojo.Customer;
import service.CustomerManager;
@RestController
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	private CustomerManager customerManager;
	@RequestMapping(method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer c) {
		return customerManager.registCustomer(c);
	}
}
