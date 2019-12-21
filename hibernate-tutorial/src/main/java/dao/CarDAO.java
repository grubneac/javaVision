package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.javavision.model.Car;

public class CarDAO implements DAO<Car, Integer> {
	
	private final SessionFactory factory;
	
	public CarDAO(SessionFactory factory) {
		this.factory=factory;
	}



	@Override
	public Car read(final Integer id) {
		try(final Session session = factory.openSession()){
			return session.get(Car.class, id);
		}
	}

}
