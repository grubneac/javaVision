package ru.javavision;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.CarDAO;
import dao.DAO;
import dao.EngineDAO;
import ru.javavision.model.Car;
import ru.javavision.model.Engine;

public class ApplicationDemo {

	public static void main(String[] args) {
		SessionFactory factory = null;
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			DAO<Engine, Integer> enginDAO = new EngineDAO(factory);
//			DAO<Car, Integer> carDAO = new CarDAO(factory);
 			read(enginDAO);

		
		} finally {
			if(factory != null)
				factory.close();
		}
	}
	private static void read (DAO<Engine, Integer> enginDAO) {
		final Engine engine =enginDAO.read(1);
		System.out.println("READ from DB ="+engine);
	}
	

}
