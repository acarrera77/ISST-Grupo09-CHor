package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;


import es.upm.dit.isst.trabajo.model.Registro;

public class RegistroDAOImplementation implements RegistroDAO {

	private static  RegistroDAOImplementation instancia = null;
	private RegistroDAOImplementation() {
	  }
	
	public static RegistroDAOImplementation getInstance() {  // Para que nunca haya mas de un objeto de esta clase en memoria
		if( null == instancia ) 
	      instancia = new RegistroDAOImplementation();
	    return instancia;
	  }
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Registro registro) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(registro);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Registro read(String id) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Registro r = session.get(Registro.class, id);
		session.getTransaction().commit();
		session.close();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Registro registro) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(registro);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Registro registro) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(registro);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Registro> readAll() {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Registro> r = session.createQuery("from Registro").list();
		session.getTransaction().commit();
		session.close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Registro login(String email, Date horaSalida) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Registro r = null;
		Query q = session.createQuery("select p from Registro p where p.worker.email = :email and p.horaSalida = :horaSalida");
		q.setParameter("email", email);
		q.setParameter("horaSalida", horaSalida);
		List<Registro> registros = q.getResultList();
		if (registros.size() > 0)
			r= (Registro) (registros.get(0));
		session.getTransaction().commit();
		session.close();
		if (r == null) {
			return null;
		}
		return r;
	}

}
