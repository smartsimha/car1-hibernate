package com.tysspl.car1_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tysspl.car1_hibernate.dto.Car;

public class CarDao {
	static Car car = new Car();

	public void saveCar(Car car) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(car);
		entityTransaction.commit();
	}

	public Car getCarById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Car c1 = entityManager.find(Car.class, 1);
		if (c1 != null) {
			return c1;
		}
		return null;
	}

	public boolean deleteCarById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Car c1 = entityManager.find(Car.class, 1);
		if (c1 != null) {

			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(car);

			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public boolean updateCarById(int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Car car1 = entityManager.find(Car.class, id);
		if (car1 != null) {
			car1.setBrand("Benz");
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(car);

			entityTransaction.commit();
			return true;
		}
		return false;

	}

	public List<Car> getAllCars() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String q = "select c from Car c";
		Query query = entityManager.createQuery(q);
		List<Car> lc = query.getResultList();
		return lc;
	}

	public List<Car> getAllCarsByBrand(String brand) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String q = "select c from Car c where c.brand=?1";
		Query query = entityManager.createQuery(q);
		query.setParameter(1, "Maruthi");

		List<Car> lc = query.getResultList();
		if (lc != null) {
			return lc;
		}
		return null;

	}

	public List<Car> getAllCarsBetweenRange(double low, double high) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String q = "select c from Car c where c.cost>=?1 and c.cost<=?2";
		Query query = entityManager.createQuery(q);
		query.setParameter(1, low);
		query.setParameter(2, high);

		List<Car> lc = query.getResultList();
		if (lc != null) {
			return lc;
		}
		return null;
	}

}
