package es.upm.dit.isst.trabajo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Proyecto implements Serializable{
	
	private static final long serialVersionUID = 1L;

@Id
 private int proyectoID;

 private String name;

}