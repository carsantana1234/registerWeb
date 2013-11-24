package org.register.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "Registro.findByName", query = "SELECT r FROM Registro r WHERE LOWER(r.name) = LOWER(?1)")
@Table(name = "registros")
public class Registro {

	
	@Id
	@GeneratedValue
	private Integer id; 
	
	private String name;
	
	private String apellido;
	
	private Integer edad;
	
	@Column(name="id_visible")
	private Integer idVisible;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getIdVisible() {
		return idVisible;
	}

	public void setIdVisible(Integer idVisible) {
		this.idVisible = idVisible;
	}

	
}
