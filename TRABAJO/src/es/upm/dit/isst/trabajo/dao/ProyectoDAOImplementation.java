package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.model.Proyecto;
import es.upm.dit.isst.trabajo.dao.ProyectoDAO;

public class ProyectoDAOImplementation implements ProyectoDAO {

	private static ProyectoDAOImplementation instance = null;
	
	public static ProyectoDAOImplementation getInstance() {
		if (null == instance)
			instance = new ProyectoDAOImplementation();
		return instance;
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

	@Override
	public void delete(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Proyecto read(Integer proyectoID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Proyecto proyecto = session.load(Proyecto.class, proyectoID);
		session.getTransaction().commit();
		session.close();
		return proyecto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Proyecto> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Proyecto> proyectos = session.createQuery("from Proyecto").list();
		session.getTransaction().commit();
		session.close();
		return proyectos;
	}

	@Override
	public void update(Proyecto proyecto) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(proyecto);
		session.getTransaction().commit();
		session.close();
	}
}
