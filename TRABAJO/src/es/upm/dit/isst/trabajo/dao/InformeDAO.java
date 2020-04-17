package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;

import es.upm.dit.isst.trabajo.model.Informe;

//He quitado lo de login
public interface InformeDAO {
	public void create(Informe tfg);
	public Informe read(Integer informeID);
	public void update(Informe tfg);
	public void delete(Informe tfg);
	public Collection<Informe> readAll();

}