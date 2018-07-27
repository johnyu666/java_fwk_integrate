package service.impl;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import pojo.Customer;
import service.CustomerManager;

public class CustomerManagerTest {
	private static ApplicationContext context;
	@BeforeClass
	public static void init() {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testRegistCustomer() throws Exception {
		Customer c=new Customer();
		c.setCname("john");
		CustomerManager manager=context.getBean(CustomerManager.class);
		Customer c1=manager.registCustomer(c);
		Assert.assertTrue(c1.getId()!=null);
	}
}
