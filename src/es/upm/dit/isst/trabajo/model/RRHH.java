package es.upm.dit.isst.trabajo.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RRHH implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	private String email;
	
	private String password;
	private String nombre;
		
	
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
		RRHH other = (RRHH) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RRHH [email=" + email + ", password=" + password + ", nombre=" + nombre +  "]";
	}
	
	
	
	
	
}
