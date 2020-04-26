package es.upm.dit.isst.trabajo.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Informe implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer informeId;

	private String ano;
	private String mes;

	@Lob
	private byte[] informe;
	
	@ManyToOne
	private Trabajador trabajador;
	
	@ManyToOne
	private GestorDeProyectos gestor;
	
	public Informe() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((informeId == null) ? 0 : informeId.hashCode());
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
		Informe other = (Informe) obj;
		if (informeId == null) {
			if (other.informeId != null)
				return false;
		} else if (!informeId.equals(other.informeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Informe [informeId=" + informeId + ", ano=" + ano + ", mes=" + mes + ", informe="
				+ Arrays.toString(informe) + ", trabajador=" + trabajador + ", gestor=" + gestor + "]";
	}

	public Integer getInformeId() {
		return informeId;
	}

	public void setInformeId(Integer informeId) {
		this.informeId = informeId;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public byte[] getInforme() {
		return informe;
	}

	public void setInforme(byte[] informe) {
		this.informe = informe;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public GestorDeProyectos getGestor() {
		return gestor;
	}

	public void setGestor(GestorDeProyectos gestor) {
		this.gestor = gestor;
	}
	
	
	
	



}
