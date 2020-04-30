package es.upm.dit.isst.trabajo.dao;

import java.util.Collection;

import es.upm.dit.isst.trabajo.model.RRHH;

public interface RRHHDAO {
	
	public void create(RRHH rrhh);
	public RRHH read(String email);
	public void update(RRHH rrhh);
	public void delete(RRHH rrhh);
	public Collection<RRHH> readAll();
	public RRHH login(String email, String password);


}
