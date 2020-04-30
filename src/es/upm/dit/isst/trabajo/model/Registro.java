package es.upm.dit.isst.trabajo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Date horaEntrada;
	private Date horaSalida;
	private Integer horaDescanso;


	@ManyToOne
	private Trabajador worker;
	
	@ManyToOne
	private Proyecto project;
	
	
	public Registro() {
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Registro other = (Registro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Registro [Id=" + id + ", HoraEntrada=" + horaEntrada + ", HoraSalida=" + horaSalida + ", HoraDescanso="
				+ horaDescanso + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getHoraEntrada() {
		return horaEntrada;
	}


	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}


	public Date getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}


	public Integer getHoraDescanso() {
		return horaDescanso;
	}


	public void setHoraDescanso(Integer horaDescanso) {
		this.horaDescanso = horaDescanso;
	}


	public Trabajador getWorker() {
		return worker;
	}


	public void setWorker(Trabajador worker) {
		this.worker = worker;
	}


	public Proyecto getProject() {
		return project;
	}


	public void setProject(Proyecto project) {
		this.project = project;
	}

	

	
	

}
