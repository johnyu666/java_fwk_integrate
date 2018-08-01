package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.ItemDao;
import pojo.Base;
import pojo.Item;
@Repository
public class ItemDaoImpl implements ItemDao {
	@PersistenceContext(name="em")
	private EntityManager em;
	@Override
	public Item addItem(Item item, String baseId) {
		Base base=em.getReference(Base.class, baseId);
		item.setBase(base);
		em.persist(item);
		return item;
	}

	@Override
	public List<Item> findItemsByBase(String baseId) {
		Base base=em.getReference(Base.class, baseId);
		String jpql="from Item item where item.base=:base";
		return em.createQuery(jpql)
				.setParameter("base", base)
				.getResultList();
	}

	@Override
	public void deleteItem(String itemId) {
		Item item=em.getReference(Item.class, itemId);
		em.remove(item);
	}

}
