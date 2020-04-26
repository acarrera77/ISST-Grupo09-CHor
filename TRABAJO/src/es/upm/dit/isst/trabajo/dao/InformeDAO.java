package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;

import es.upm.dit.isst.trabajo.model.Informe;

public interface InformeDAO {
	public void create(Informe informe);
	public Informe read(Integer informeId);
	public void update(Informe informe);
	public void delete(Informe informe);
	public Collection<Informe> readAll();

}