package ru.javavision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
//			update(enginDAO);
//			create(enginDAO);
//			delete(enginDAO);
		
		} finally {
			if(factory != null)
				factory.close();
		}
	}
	private static void read (DAO<Engine, Integer> enginDAO) {
		final Engine engine =enginDAO.read(1);
		System.out.println("READ from DB ="+engine);
	}
	
	private static void update (DAO<Engine, Integer> enginDAO) {
		Engine engine =enginDAO.read(1);
		System.out.println("Before UPDATE="+engine);
		engine.setName("Turbo30");
		engine.setCarMark("Lada");
		enginDAO.update(engine);
		System.out.println("After UPDATE ="+engine);
		Engine engine2 =enginDAO.read(1);
		System.out.println("READ from DB ="+engine2);
		
	}
	private static void create(DAO<Engine,Integer> engineDAO) {
		Engine newEngine= new Engine();
		newEngine.setName("NewEngine");
		newEngine.setPower(100500);
		newEngine.setCarMark("Ferarry");
		Car newCar = new Car();
		newCar.setMark("Ferarry");
		newCar.setCost(10000000);
		Set<Car> cars =new HashSet<>();
		cars.add(newCar);
		newEngine.setCars(cars);
		engineDAO.create(newEngine);
	}
	
	private static void delete(DAO<Engine,Integer> engineDAO) {
		Engine engineForDelete = engineDAO.read(1);
		engineDAO.delete(engineForDelete);
		System.out.println(engineDAO.read(1));
	}
	

}
