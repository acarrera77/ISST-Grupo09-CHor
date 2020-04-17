package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;

import es.upm.dit.isst.trabajo.model.GestorDeProyectos;


public interface GestorDeProyectosDAO {
	
	public void create(GestorDeProyectos gestor);
	public GestorDeProyectos read(String email);
	public void update(GestorDeProyectos gestor);
	public void delete(GestorDeProyectos gestor);
	public Collection<GestorDeProyectos> readAll();
	public GestorDeProyectos login(String email, String psd);
}
