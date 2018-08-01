package service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BaseDao;
import dao.ItemDao;
import pojo.Base;
import pojo.Item;
import service.BaseItemManager;

@Service
public class BaseItemManagerImpl implements BaseItemManager{
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private ItemDao itemDao;
	@Transactional
	@Override
	public Base addBase(Base base) {
		return baseDao.addBase(base);
	}
	@Transactional
	@Override
	public Item addItem(Item item, String baseId) {
		
		return itemDao.addItem(item, baseId);
	}
	@Transactional
	@Override
	public void deleteBase(String baseId) {
		baseDao.deleteBase(baseId);
		
	}
	@Transactional
	@Override
	public void deleteItem(String itemId) {
		itemDao.deleteItem(itemId);
		
	}

	@Override
	public List<Item> findItemsByBase(String baseId) {
		List<Item> items=itemDao.findItemsByBase(baseId);
		
		return items;
	}
	@Override
	public List<Base> findAllBases(){
		List<Base> rs=new ArrayList<Base>();
		List<Base> bases=baseDao.findAllBases();
		for(Base base:bases) {
			System.out.println(base.getItems().getClass());
//			Base b=new Base();
//			b.setId(base.getId());
//			b.setBaseName(base.getBaseName());
//			rs.add(b);
		}
		return bases;
	}

}
