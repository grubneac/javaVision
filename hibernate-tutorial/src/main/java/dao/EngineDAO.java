package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.javavision.model.Engine;

public class EngineDAO implements DAO<Engine, Integer> {

	private final SessionFactory factory;
	
	public EngineDAO( final SessionFactory factory) {
		this.factory = factory;
	}


	@Override
	public Engine read(Integer id) {
		try(final Session session = factory.openSession()) {
			return  session.get(Engine.class, id);
		}
	}



}
