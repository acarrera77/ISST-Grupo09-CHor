package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.model.Trabajador;

public class TrabajadorDAOImplementation implements TrabajadorDAO {
	
	private static  TrabajadorDAOImplementation instancia = null;
	private TrabajadorDAOImplementation() {
	  }
	
	public static TrabajadorDAOImplementation getInstance() {  // Para que nunca haya mas de un objeto de esta clase en memoria
		if( null == instancia ) 
	      instancia = new TrabajadorDAOImplementation();
	    return instancia;
	  }

	@SuppressWarnings("unchecked")
	@Override
	public void create(Trabajador trabajador) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(trabajador);
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Trabajador read(String email) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Trabajador t = session.get(Trabajador.class, email);
		session.getTransaction().commit();
		session.close();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Trabajador trabajador) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(trabajador);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Trabajador trabajador) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(trabajador);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Trabajador> readAll(){
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Trabajador> t = session.createQuery("from Trabajador").list();
		session.getTransaction().commit();
		session.close();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Trabajador login(String email, String password) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Trabajador t = null;
		Query q = session.createQuery("select t from Trabajador t where t.email = :email and t.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Trabajador> trabajadores = q.getResultList();
		if (trabajadores.size() > 0)
			t = (Trabajador) (q.getResultList().get(0));
		session.getTransaction().commit();
		session.close();
		return t;		
	}

}
