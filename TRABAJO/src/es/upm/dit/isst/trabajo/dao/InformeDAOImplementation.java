package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.model.Informe;
import es.upm.dit.isst.trabajo.model.Registro;

public class InformeDAOImplementation implements InformeDAO {

	private static InformeDAOImplementation instance = null;
	
	private InformeDAOImplementation() {
		
	}
	
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

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Informe informe) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.delete(informe);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Informe read(Integer informeId) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Informe informe = session.get(Informe.class, informeId);
		session.getTransaction().commit();
		session.close();
		return informe;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Informe> readAll() {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		List<Informe> informes = session.createQuery("from Informe").list();
		session.getTransaction().commit();
		session.close();
		return informes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Informe informe) {
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		session.saveOrUpdate(informe);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Informe login(String email, String mes, String ano) {
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Informe i = null;
		Query q = session.createQuery("select p from Informe p where p.trabajador.email = :email and p.mes = :mes and p.ano =:ano");
		q.setParameter("email", email);
		q.setParameter("mes", mes);
		q.setParameter("ano", ano);
		List<Informe> informe = q.getResultList();
		if (informe.size() > 0) 
			i = (Informe) (informe.get(0));
		session.getTransaction().commit();
		session.close();
		if (i == null) {
			return null;
		}
		return i;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Informe> login2(String email, String ano){
		
		
		Session session = SessionFactoryService.get().openSession();
		session.beginTransaction();
		Query q = session.createQuery("select p from Informe p where p.trabajador.email = :email and p.ano = :ano");
		q.setParameter("email", email);
		q.setParameter("ano", ano);
		List<Informe> informe = q.getResultList();
		if (informe.size() > 0) {
			session.getTransaction().commit();
			session.close();
			return informe;
		}
		session.getTransaction().commit();
		session.close();

		return null;
		
	}
}