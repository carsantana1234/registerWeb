package org.register.service;

import java.util.List;

import javax.annotation.Resource;



import org.register.model.Registro;
import org.register.repository.RegistroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroServiceImpl implements RegistroService {

	@Resource
	RegistroRepository registroRepository;

	@Transactional
	public Registro create(Registro registro) {
		Registro created = registro;
		return registroRepository.save(created);
	}

	@Transactional(readOnly=true)
	public List<Registro> findAll() {
		
		return registroRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public List<Registro> findByName(String name) {
		
		return registroRepository.findByName(name);
	}
	
	@Transactional(readOnly=true)
	public Registro findById(int id) {
		return registroRepository.findOne(id);
		
	}
	
	@Transactional
	public Registro update(Registro reg){
		
		Registro registroUpdate = registroRepository.findOne( reg.getId() );
		registroUpdate.setName( reg.getName() );
		registroUpdate.setApellido(reg.getApellido());
		registroUpdate.setEdad(reg.getEdad());
		registroUpdate.setIdVisible(reg.getIdVisible());
		
		return registroUpdate;
		
	}

	@Transactional
	public Registro delete(int id) {
		
		Registro regDelete = registroRepository.findOne(id);
		registroRepository.delete( regDelete );
		return regDelete;
	} 
	
	
	/*
	@Transactional
	@PostConstruct
	public void populate(){
		System.out.println("ENtrando al POSTTTTTTTTT");
		Registro r = new Registro();
		r.setName("Maik");
		registroRepository.saveAndFlush(r);
		
		
	}
	*/

}
