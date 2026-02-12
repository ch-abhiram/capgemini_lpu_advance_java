package com.onetoonemapping;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class User {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
	}

}
