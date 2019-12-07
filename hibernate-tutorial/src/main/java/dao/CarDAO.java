package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.javavision.model.Car;

public class CarDAO implements DAO<Car, Integer> {
	
	private final SessionFactory factory;
	
	public CarDAO(SessionFactory factory) {
		this.factory=factory;
	}

	@Override
	public void create(final Car car) {
		try(final Session session = factory.openSession()){
			session.beginTransaction();
			session.save(car);
			session.getTransaction().commit();
		}
	}

	@SuppressWarnings("null")
	@Override
	public Car read(final Integer id) {
		try(final Session session = factory.openSession()){
			final Car result = session.get(Car.class, id);
			return result;
		}
	}

	@Override
	public void update(final Car car) {
		try(final Session session = factory.openSession()){
			session.beginTransaction();
			session.update(car);
			session.getTransaction().commit();
		}		
	}

	@Override
	public void delete(final Car car) {
		try(final Session session = factory.openSession()){
			session.beginTransaction();
			session.delete(car);
			session.getTransaction().commit();
		}				
	}

}
