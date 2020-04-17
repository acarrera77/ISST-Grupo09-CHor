package es.upm.dit.isst.trabajo.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Informe implements Serializable{
	
	private static final long serialVersionUID = 1L;

@Id
 private int informeID;

 private String Ano;
 private String Mes;

@Lob
private byte[] informe;



}
