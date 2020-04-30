package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.Date;

import es.upm.dit.isst.trabajo.model.Asociaciones;


public interface AsociacionesDAO {
	public void create(Asociaciones asociacion);
	public Asociaciones read(String asociacionesId);
	public void update(Asociaciones asociacion);
	public void delete(Asociaciones asociacion);
	public Collection<Asociaciones> readAll();
	public Asociaciones login(String email, String proyectoId); 

}
