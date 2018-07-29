package controller;

import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pojo.Customer;
import pojo.CustomerErrorMessage;
import service.CustomerManager;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	private CustomerManager customerManager;
	@RequestMapping(method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer c) {
		return customerManager.registCustomer(c);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Customer> findAllCustomers() {
		return customerManager.findAllCustomers();
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.PUT)
	public Customer updateCustomer(@PathVariable String id,@RequestBody Customer c) {
		return customerManager.updateCustomer(id, c);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable String id) {
		 customerManager.deleteCustomer(id);
		 return "{}";
	}
	@ResponseBody
	@ExceptionHandler(value=javax.persistence.PersistenceException.class)
	public Map<String, CustomerErrorMessage> runTimeExceptionHandler(Exception e) {
		CustomerErrorMessage msg=new CustomerErrorMessage();
		msg.setCode(405);msg.setReason("not found");
		Map<String, CustomerErrorMessage> map=new HashMap<String, CustomerErrorMessage>();
		map.put("error", msg);
		return map;
	}
}
