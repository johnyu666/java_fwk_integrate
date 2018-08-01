package service;

import java.util.List;

import org.hibernate.collection.internal.PersistentSet;

import pojo.Base;
import pojo.Item;

public interface BaseItemManager {
	public Base addBase(Base base);
	public Item addItem(Item item,String baseId);
	public void deleteBase(String baseId);
	public void deleteItem(String itemId);
	public List<Item> findItemsByBase(String baseId);
	public List<Base> findAllBases();
	
}
