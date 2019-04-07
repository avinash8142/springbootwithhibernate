package com.web.restfulwebservices.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.restfulwebservices.model.Merchant;

@Repository
@Transactional
public class HelloDaoImpl implements HelloDao {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Merchant> display() {
		System.out.println("in the dao");
		String sql = "select * from employee";
		List<Object[]> list = sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		System.out.println("size is " + list.size());
		for (Object[] o : list) {
			System.out.println(o[0] + " " + o[1] + " " + o[2]);
		}
		
		
		
		List<Merchant> listOfmchnts = sessionFactory.getCurrentSession().createQuery("from Merchant").list();
		System.out.println("merchant "+listOfmchnts);
		return listOfmchnts;
	}

}
