package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.javavision.model.Engine;

public class EngineDAO implements DAO<Engine, String> {

	private final SessionFactory factory;
	
	public EngineDAO( final SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void create(Engine entity) {
		try(final Session session = factory.openSession()) {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} 
	}

	@Override
	public Engine read(String key) {
		try(final Session session = factory.openSession()) {
			final Engine result = session.find(Engine.class, key);
	 		return result != null? result: new Engine();
		}
	}

	@Override
	public void update(Engine entity) {
		try(final Session session = factory.openSession()) {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
		} 		
	}

	@Override
	public void delete(Engine entity) {
		try(final Session session = factory.openSession()) {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} 		
	}

}
