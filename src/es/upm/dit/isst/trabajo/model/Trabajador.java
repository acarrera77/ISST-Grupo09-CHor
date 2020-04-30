package es.upm.dit.isst.trabajo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trabajador implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	private String email;
	
	private String password;
	private String name;
	
	@OneToMany(mappedBy = "worker", fetch = FetchType.LAZY)
	
	private Collection<Registro> registrostrabajadores;
	
	@OneToMany(mappedBy = "trabajadores", fetch = FetchType.LAZY)
	
	private Collection<Asociaciones> asociacionestrabajadores;
	
	@OneToMany(mappedBy = "trabajador", fetch = FetchType.LAZY)
	
	private Collection<Informe> informestrabajadores;
	
	
	public Trabajador() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Trabajador other = (Trabajador) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trabajador [email=" + email + ", password=" + password + ", name=" + name + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Registro> getRegistrosTrabajadores() {
		return registrostrabajadores;
	}

	public void setRegistrosTrabajadores(Collection<Registro> registrostrabajadores) {
		this.registrostrabajadores = registrostrabajadores;
	}

	public Collection<Asociaciones> getAsociacionesTrabajadores() {
		return asociacionestrabajadores;
	}

	public void setAsociacionesTrabajadores(Collection<Asociaciones> asociacionestrabajadores) {
		this.asociacionestrabajadores = asociacionestrabajadores;
	}

	public Collection<Informe> getInformestrabajadores() {
		return informestrabajadores;
	}

	public void setInformestrabajadores(Collection<Informe> informestrabajadores) {
		this.informestrabajadores = informestrabajadores;
	}
	

}
