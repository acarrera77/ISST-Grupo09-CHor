package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;

import es.upm.dit.isst.trabajo.model.Proyecto;

//He quitado lo de login
public interface ProyectoDAO {
	public void create(Proyecto proyecto);
	public Proyecto read(Integer proyectoID);
	public void update(Proyecto proyecto);
	public void delete(Proyecto proyecto);
	public Collection<Proyecto> readAll();

}