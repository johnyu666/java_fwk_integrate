package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.BaseDao;
import pojo.Base;
@Repository
public class BaseDaoImpl implements BaseDao{
	@PersistenceContext(name="em")
	private EntityManager em;
	@Override
	public Base addBase(Base base) {
		em.persist(base);
		return base;
	}

	@Override
	public void deleteBase(String id) {
		Base base=em.getReference(Base.class, id);
		em.remove(base);
	}

	@Override
	public List<Base> findAllBases() {
		//String jpql="from Base base join fetch base.items";
		String jpql="from Base";
		return em.createQuery(jpql).getResultList();
	}

}
