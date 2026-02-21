package com.onetoonemapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class User {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		 EntityManager em = emf.createEntityManager();

	        // Create Engine
	        Engine engine = new Engine();
	        engine.setId(101);
	        engine.setType("Petrol Engine");
	        engine.setFuelType("Petrol");
	        engine.setMileage("18 km/l");
	        engine.setCc("1500cc");

	        // Create Car
	        Car car = new Car();
	        car.setId(1);
	        car.setBrand("Toyota");
	        car.setModel("Corolla");
	        car.setModelYear("2023");
	        car.setPrice(1500000);
	        car.setEngine(engine);

	        // Begin Transaction
	        em.getTransaction().begin();

	        // Persist Engine first (important without cascade)
	        em.persist(engine);
	        em.persist(car);

	        em.getTransaction().commit();

	        System.out.println("Car and Engine saved successfully!");

	        // Fetch Data
	        Car fetchedCar = em.find(Car.class, 1);
	        System.out.println("Fetched Car: " + fetchedCar);
	        System.out.println("Engine Details: " + fetchedCar.getEngine());

	        em.close();
	        emf.close();
		
	}

}
