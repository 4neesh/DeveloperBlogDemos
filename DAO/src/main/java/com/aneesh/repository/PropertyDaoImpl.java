package com.aneesh.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aneesh.entity.Property;

@Repository
public class PropertyDaoImpl implements PropertyDao {

	SessionFactory sessionFactory;
	
	@Override
	public List<Property> getProperties() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Property> query = session.createQuery("from property order by id", Property.class);
		
		List<Property> result = query.getResultList();
		return result;
	}

	@Override
	public void saveProperty(Property property) {
		Session session = sessionFactory.getCurrentSession();

		System.out.println("REPO SAVING");
		session.saveOrUpdate(property);
	}

	@Override
	public Property getProperty(int id) {
		Session session = sessionFactory.getCurrentSession();

		Property property = session.get(Property.class, id);
		return property;
	}

	@Override
	public void deleteProperty(int id) {
		Session session = sessionFactory.getCurrentSession();

		Query<Property> query = session.createQuery("delete from Property where id=:id", Property.class);
		query.executeUpdate();
	}

}
