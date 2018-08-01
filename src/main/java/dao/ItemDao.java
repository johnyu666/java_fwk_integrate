package dao;

import java.util.List;

import pojo.Item;

public interface ItemDao {
	public Item addItem(Item item,String baseId);
	public List<Item> findItemsByBase(String baseId);
	public void deleteItem(String itemId);
}
