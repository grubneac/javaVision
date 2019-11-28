package ru.javavision;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.DAO;
import dao.EngineDAO;
import ru.javavision.model.Engine;

public class ApplicationDemo {

	public static void main(String[] args) {
		SessionFactory factory = null;
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
			DAO<Engine, String> enginDAO = new EngineDAO(factory);
			Engine engine = new Engine();
			engine.setModel("New Model");
			engine.setPower(12345);
			enginDAO.create(engine);
			
			Engine newEngine = enginDAO.read("New Model");
			System.out.println("newEngine="+newEngine);
			
			newEngine.setPower(54321);
			enginDAO.update(newEngine);
			
			engine =enginDAO.read("New Model");
			System.out.println(engine);
			
			enginDAO.delete(engine);
			
			
		} finally {
			if(factory != null)
				factory.close();
		}
	}

}
