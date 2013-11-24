package org.register.service;

import java.util.List;

import org.register.model.Registro;

public interface RegistroService {
	
	public Registro create(Registro registro);
	
	public List<Registro> findAll();
	
	public List<Registro> findByName(String name);
	
	public Registro findById(int id);
	
	public Registro update(Registro reg);
	
	public Registro delete(int id);

}
