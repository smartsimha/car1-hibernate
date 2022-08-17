package com.tysspl.car1_hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tysspl.car1_hibernate.dto.User;

public class UserDao {
	public void saveUser(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

	}

	public User validateUser(String email, String pass) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String query = "select u from User u where u.email=?1 and u.password=?2";
		Query query2 = entityManager.createQuery(query);
		query2.setParameter(1, email);
		query2.setParameter(2, pass);
		User user = (User) query2.getSingleResult();
		if (user != null) {
			return user;
		}
		return null;

	}

	public boolean deleteUser(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}
	public User getUserByEmail(String email) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String q="select u from User u where u.email=:simha";
		Query query=entityManager.createQuery(q);
		query.setParameter("simha", email);
		User user=(User)query.getSingleResult();
		
		
		return user;
		
	}

}
