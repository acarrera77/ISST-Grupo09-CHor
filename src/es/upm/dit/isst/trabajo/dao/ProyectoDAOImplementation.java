package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.model.Proyecto;
import es.upm.dit.isst.trabajo.model.Trabajador;

public class ProyectoDAOImplementation implements ProyectoDAO {


	private static  ProyectoDAOImplementation instancia = null;
	private ProyectoDAOImplementation() {
	  }

	public static ProyectoDAOImplementation getInstance() {  // Para que nunca haya mas de un objeto de esta clase en memoria
		if( null == instancia ) 
	      instancia = new ProyectoDAOImplementation();
	    return instancia;
	  }
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Proyecto proyecto) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(proyecto);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Proyecto read(String proyectoId) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Proyecto t = session.get(Proyecto.class, proyectoId);
		session.getTransaction().commit();
		session.close();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Proyecto proyecto) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(proyecto);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Proyecto proyecto) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(proyecto);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Proyecto> readAll() {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Proyecto> t = session.createQuery("from Proyecto").list();
		session.getTransaction().commit();
		session.close();
		return t;
	}

}
