package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;

import es.upm.dit.isst.trabajo.model.Trabajador;

public interface TrabajadorDAO {
	
	public void create(Trabajador trabajador);
	public Trabajador read(String email);
	public void update(Trabajador trabajador);
	public void delete(Trabajador trabajador);
	public Collection<Trabajador> readAll();
	public Trabajador login(String email, String password);

}
