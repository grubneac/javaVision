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
/*			Engine engine = new Engine();
			engine.setModel("New Model");
			engine.setPower(12345);
			enginDAO.create(engine);
			
			Engine newEngine = enginDAO.read("New Model");
			System.out.println("newEngine="+newEngine);
			
			newEngine.setPower(54321);
			enginDAO.update(newEngine);
			
			engine =enginDAO.read(1);
			System.out.println(engine);
			
			enginDAO.delete(engine);
*/
			DAO<Car, Integer> dao = new CarDAO(factory);
			final Car car = dao.read(1);
			System.out.println("CREATE: "+car);
			
			car.setModel("Mazda");
			car.getEngine().setPower(500);
			car.getEngine().setModel("Super Engine");
			dao.update(car);
			System.out.println("UPDATE= "+dao.read(1));
			
			
			Car newCar = new Car();
			newCar.setModel("Transporter2");
			newCar.setMark("VW");
			Engine newEngine = new Engine();
			newEngine.setModel("4-cilidr");
			newEngine.setPower(1400);
			newCar.setEngine(newEngine);
			dao.create(newCar);
			System.out.println("CREARED= "+dao.read(2));
			
			dao.delete(newCar);
		
			
			
			
		} finally {
			if(factory != null)
				factory.close();
		}
	}

}
