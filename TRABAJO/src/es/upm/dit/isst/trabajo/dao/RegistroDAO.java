package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import es.upm.dit.isst.trabajo.model.Registro;

public interface RegistroDAO {
	
	public void create(Registro registro);
	public Registro read(String id);
	public void update(Registro registro);
	public void delete(Registro registro);
	public Collection<Registro> readAll();
	public Registro login (String email, Date horaSalida);
	public List<Registro> login2(String email, String proyectoId);


}
