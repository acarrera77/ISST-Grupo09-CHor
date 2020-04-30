package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;

import es.upm.dit.isst.trabajo.model.Proyecto;

public interface ProyectoDAO {

	public void create(Proyecto proyecto);
	public Proyecto read(String proyectoId);
	public void update(Proyecto proyecto);
	public void delete(Proyecto proyecto);
	public Collection<Proyecto> readAll();
}
