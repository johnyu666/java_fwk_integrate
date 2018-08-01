package service.impl;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Base;
import pojo.Customer;
import pojo.Item;
import service.BaseItemManager;
import service.CustomerManager;

public class BaseItemManagerTest {
	private static ApplicationContext context;
	private BaseItemManager manager;
	@BeforeClass
	public static void init() {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Before
	public void start() {
		manager=context.getBean(BaseItemManager.class);
	}
	@Test
	public void testAddBase() throws Exception {
		Base base=new Base();
		base.setBaseName("base1");
		manager.addBase(base);
		
	}
	@Test
	public void testAddItem() throws Exception {
		Item item=new Item();
		item.setItemName("item1");
		Base base=new Base();
		base.setBaseName("base2");
		manager.addBase(base);
		item.setBase(base);
		manager.addItem(item, base.getId());
		System.out.println(base.getId());
		
	}
	@Test
	public void testDeleteBase() {
		Item item=new Item();
		item.setItemName("item1");
		Base base=new Base();
		base.setBaseName("base2");
		manager.addBase(base);
		item.setBase(base);
		manager.addItem(item, base.getId());
		manager.deleteBase(base.getId());
	}
	
	@Test
	public void testFindItemsByBase() {
		Item item=new Item();
		item.setItemName("item1");
		Base base=new Base();
		base.setBaseName("base2");
		manager.addBase(base);
		
		item.setBase(base);
		manager.addItem(item, base.getId());
		
		List<Item> items=manager.findItemsByBase(base.getId());
		Assert.assertTrue(items.size()==1);
		
	}
	
	@Test
	public void testDeleteItem() {
		Item item=new Item();
		item.setItemName("item1");
		Base base=new Base();
		base.setBaseName("base2");
		manager.addBase(base);
		
		item.setBase(base);
		manager.addItem(item, base.getId());
		
		manager.deleteItem(item.getId());
		
		List<Item> items=manager.findItemsByBase(base.getId());
		Assert.assertTrue(items.size()==0);
	}
}
