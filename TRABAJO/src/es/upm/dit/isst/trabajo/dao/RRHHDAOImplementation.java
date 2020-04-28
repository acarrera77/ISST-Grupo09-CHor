package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.model.GestorDeProyectos;
import es.upm.dit.isst.trabajo.model.RRHH;
import es.upm.dit.isst.trabajo.model.Trabajador;

public class RRHHDAOImplementation implements RRHHDAO {
	
	private static RRHHDAOImplementation instance = null;
	private RRHHDAOImplementation() {
	  }

	public static RRHHDAOImplementation getInstance() {
		if (null == instance)
			instance = new RRHHDAOImplementation();
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(RRHH rrhh) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( rrhh );
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public RRHH read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		RRHH g = session.load( RRHH.class, email );
		session.getTransaction().commit();
		session.close();
		return g;
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(RRHH rrhh) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(rrhh);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(RRHH rrhh) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( rrhh );
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<RRHH> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<RRHH> gs = session.createQuery("from RRHH").list();
		session.getTransaction().commit();
		session.close();
		return gs;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public RRHH login(String email, String password) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		RRHH r = null;
		Query q = session.createQuery("select t from RRHH t where t.email = :email and t.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<RRHH> rrhh = q.getResultList();
		if (rrhh.size() > 0)
			r = (RRHH) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return r;		
	}

}
