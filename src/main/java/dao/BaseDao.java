package dao;

import java.util.List;

import pojo.Base;

public interface BaseDao {
	public Base addBase(Base base);
	public void deleteBase(String id);
	public List<Base> findAllBases();
	
}
