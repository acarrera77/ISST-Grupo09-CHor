package es.upm.dit.isst.trabajo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Proyecto implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	private String proyectoId;

	private String name;
	
	@OneToMany(mappedBy = "proyectos", fetch = FetchType.LAZY)
	
	private Collection<Asociaciones> asociacionesproyectos;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	
	private Collection<Registro> registroproyectos;
	
	
	public Proyecto() {
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((proyectoId == null) ? 0 : proyectoId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		if (proyectoId == null) {
			if (other.proyectoId != null)
				return false;
		} else if (!proyectoId.equals(other.proyectoId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Proyecto [proyectoId=" + proyectoId + ", name=" + name + "]";
	}


	public String getProyectoId() {
		return proyectoId;
	}


	public void setProyectoId(String proyectoId) {
		this.proyectoId = proyectoId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Collection<Asociaciones> getAsociacionesproyectos() {
		return asociacionesproyectos;
	}


	public void setAsociacionesproyectos(Collection<Asociaciones> asociacionesproyectos) {
		this.asociacionesproyectos = asociacionesproyectos;
	}


	public Collection<Registro> getRegistroproyectos() {
		return registroproyectos;
	}


	public void setRegistroproyectos(Collection<Registro> registroproyectos) {
		this.registroproyectos = registroproyectos;
	}

	
}
