package com.tysspl.car1_hibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.tysspl.car1_hibernate.dao.CarDao;
import com.tysspl.car1_hibernate.dto.Car;

public class TestCarController {
	static CarDao carDao = new CarDao();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestCarController.choices();
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Enter car details");
			Car car = new Car();
			car.setId(sc.nextInt());
			car.setBrand(sc.next());
			car.setName(sc.next());
			car.setCost(sc.nextDouble());
			carDao.saveCar(car);
		}
			break;
		case 2: {
			System.out.println("Enter the car id");
			Car car = carDao.getCarById(sc.nextInt());
			System.out.println(car);
		}
			break;
		case 3: {
			System.out.println("Enter the car id");

			boolean b = carDao.deleteCarById(sc.nextInt());
			if (b) {
				System.out.println("car deleted successfully");
			} else {
				System.out.println("There is no car with given id");
			}
		}
			break;
		case 4: {
			System.out.println("Enter the car id");
			boolean b = carDao.updateCarById(sc.nextInt());
			if (b) {
				System.out.println("car details updated successfully");
			} else {
				System.out.println("There is no car with given id");
			}

		}
			break;
		case 5: {
			List<Car> lc = carDao.getAllCars();
			if (lc != null) {
				System.out.println(lc);
			} else {
				System.out.println("no cars available");
			}
		}
			break;
		case 6: {
			System.out.println("Enter the car brand");
			List<Car> lc = carDao.getAllCarsByBrand(sc.next());
			if (lc != null) {
				System.out.println(lc);
			} else {
				System.out.println("no cars available");
			}
		}
			break;
		case 7: {
			System.out.println("Enter the range");
			List<Car> lc = carDao.getAllCarsBetweenRange(sc.nextDouble(), sc.nextDouble());
			if (lc != null) {
				System.out.println(lc);
			} else {
				System.out.println("No cars available");
			}
		}
		break;
		default :{
			System.out.println("invalid choice");
		}
		
		}

	}

	public static void choices() {
		System.out.println("Enter 1 to save the car");
		System.out.println("Enter 2 to get car by id");
		System.out.println("Enter 3 to delete car by id");
		System.out.println("Enter 4 to update car by id");
		System.out.println("Enter 5 to get all cars");
		System.out.println("Enter 6 to get all cars by brand");
		System.out.println("Enter 7 to to get all cars within range of cost");
	}

}
