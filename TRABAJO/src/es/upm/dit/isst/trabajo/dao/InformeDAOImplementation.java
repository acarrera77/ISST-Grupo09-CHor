package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.model.Informe;

public class InformeDAOImplementation implements InformeDAO {

	private static InformeDAOImplementation instance = null;
	
	public static InformeDAOImplementation getInstance() {
		if (null == instance)
			instance = new InformeDAOImplementation();
		return instance;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void create(Informe informe) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.save(informe);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Informe informe) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(informe);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Informe read(Integer informeID) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Informe informe = session.load(Informe.class, informeID);
		session.getTransaction().commit();
		session.close();
		return informe;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Informe> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Collection<Informe> informes = session.createQuery("from Informe").list();
		session.getTransaction().commit();
		session.close();
		return informes;
	}

	@Override
	public void update(Informe informe) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(informe);
		session.getTransaction().commit();
		session.close();
	}

}