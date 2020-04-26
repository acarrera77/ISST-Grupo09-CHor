package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.model.Asociaciones;
import es.upm.dit.isst.trabajo.model.Registro;

public class AsociacionesDAOImplementation implements AsociacionesDAO {
	
	private static AsociacionesDAOImplementation instancia = null;
	
	private AsociacionesDAOImplementation() {
		
	}
	
	public static AsociacionesDAOImplementation getInstance() {  // Para que nunca haya mas de un objeto de esta clase en memoria
		if( null == instancia ) 
	      instancia = new AsociacionesDAOImplementation();
	    return instancia;
	  }

	@SuppressWarnings("unchecked")
	@Override
	public void create(Asociaciones asociacion) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(asociacion);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Asociaciones read(String asociacionesId) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Asociaciones r = session.get(Asociaciones.class, asociacionesId);
		session.getTransaction().commit();
		session.close();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Asociaciones asociacion) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(asociacion);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Asociaciones asociacion) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(asociacion);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Asociaciones> readAll() {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Asociaciones> r = session.createQuery("from Asociaciones").list();
		session.getTransaction().commit();
		session.close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Asociaciones login(String email, String proyectoId) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Asociaciones a = null;
		Query q = session.createQuery("select p from Asociaciones p where p.trabajadores.email = :email and p.proyectos.proyectoId = :proyectoId");
		q.setParameter("email", email);
		q.setParameter("proyectoId", proyectoId);
		List<Asociaciones> asociacion = q.getResultList();
		if (asociacion.size() > 0)
			a= (Asociaciones) (asociacion.get(0));
		session.getTransaction().commit();
		session.close();
		if (a == null) {
			return null;
		}
		return a;
	}

}
