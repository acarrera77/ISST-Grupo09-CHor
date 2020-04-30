package es.upm.dit.isst.trabajo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GestorDeProyectos implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	private String email;
	
	private String password;
	private String nombre;
	
	@OneToMany(mappedBy = "gestores", fetch = FetchType.LAZY)
	
	private Collection<Asociaciones> asociacionesgestores;
	
	@OneToMany(mappedBy = "gestor", fetch = FetchType.LAZY)
	
	private Collection<Informe> informesgestores;
	
	
	//Getters y setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getpassword() {
		return password;
	}
	public void setContraseñaG(String contraseñaG) {
		this.password = contraseñaG;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Collection<Asociaciones> getAsociacionesgestores() {
		return asociacionesgestores;
	}
	public void setAsociacionesgestores(Collection<Asociaciones> asociacionesgestores) {
		this.asociacionesgestores = asociacionesgestores;
	}
	
	
	public Collection<Informe> getInformesgestores() {
		return informesgestores;
	}
	public void setInformesgestores(Collection<Informe> informesgestores) {
		this.informesgestores = informesgestores;
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
		GestorDeProyectos other = (GestorDeProyectos) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GestorDeProyectos [email=" + email + ", password=" + password + ", nombre=" + nombre +  "]";
	}
	
	
	
	
	
}
