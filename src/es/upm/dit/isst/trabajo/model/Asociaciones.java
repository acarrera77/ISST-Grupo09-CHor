package es.upm.dit.isst.trabajo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Asociaciones implements Serializable {
	
private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer asociacionesId;
	
	@ManyToOne
	private Trabajador trabajadores;
	
	@ManyToOne
	private Proyecto proyectos;
	
	@ManyToOne
	private GestorDeProyectos gestores;
	
	public Asociaciones() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asociacionesId == null) ? 0 : asociacionesId.hashCode());
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
		Asociaciones other = (Asociaciones) obj;
		if (asociacionesId == null) {
			if (other.asociacionesId != null)
				return false;
		} else if (!asociacionesId.equals(other.asociacionesId))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Asociaciones [asociacionesId=" + asociacionesId + ", trabajadores=" + trabajadores + ", proyectos="
				+ proyectos + ", gestores=" + gestores + "]";
	}

	public Integer getAsociacionesId() {
		return asociacionesId;
	}

	public void setAsociacionesId(Integer asociacionesId) {
		this.asociacionesId = asociacionesId;
	}

	public Trabajador getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(Trabajador trabajadores) {
		this.trabajadores = trabajadores;
	}

	public Proyecto getProyectos() {
		return proyectos;
	}

	public void setProyectos(Proyecto proyectos) {
		this.proyectos = proyectos;
	}

	public GestorDeProyectos getGestores() {
		return gestores;
	}

	public void setGestores(GestorDeProyectos gestores) {
		this.gestores = gestores;
	}
	
	
	
}
