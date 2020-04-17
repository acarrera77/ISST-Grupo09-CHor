package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.model.GestorDeProyectos;
import es.upm.dit.isst.trabajo.model.Trabajador;


public class GestorDeProyectosDAOImplementation implements GestorDeProyectosDAO {
	
	private static GestorDeProyectosDAOImplementation instance = null;
	private GestorDeProyectosDAOImplementation() {
	  }
	
	public static GestorDeProyectosDAOImplementation getInstance() {
		if (null == instance)
			instance = new GestorDeProyectosDAOImplementation();
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(GestorDeProyectos gestor) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save( gestor );
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(GestorDeProyectos gestor) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete( gestor );
		session.getTransaction().commit();
		session.close();
		}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(GestorDeProyectos gestor) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(gestor);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public GestorDeProyectos read(String email) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		GestorDeProyectos g = session.load( GestorDeProyectos.class, email );
		session.getTransaction().commit();
		session.close();
		return g;
		}
	
	@SuppressWarnings("unchecked")
	@Override
public Collection<GestorDeProyectos> readAll(){
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<GestorDeProyectos> gs = session.createQuery("from GestorDeProyectos").list();
		session.getTransaction().commit();
		session.close();
		return gs;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public GestorDeProyectos login(String email, String password) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		GestorDeProyectos p = null;
		Query q = session.createQuery("select p from GestorDeProyectos p where p.email = :email and p.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<GestorDeProyectos> gestores = q.getResultList();
		if (gestores.size() > 0)
			p = (GestorDeProyectos) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return p;
	}
}
