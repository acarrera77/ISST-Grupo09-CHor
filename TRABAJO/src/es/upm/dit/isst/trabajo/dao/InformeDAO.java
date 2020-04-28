package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.List;

import es.upm.dit.isst.trabajo.model.Informe;
import es.upm.dit.isst.trabajo.model.Registro;

public interface InformeDAO {
	public void create(Informe informe);
	public Informe read(Integer informeId);
	public void update(Informe informe);
	public void delete(Informe informe);
	public Collection<Informe> readAll();
	public Informe login(String email, String mes, String ano);
	public List<Informe> login2(String email, String ano);
	
}