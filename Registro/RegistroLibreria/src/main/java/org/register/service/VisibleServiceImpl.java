package org.register.service;

import java.util.List;

import org.register.model.Visible;
import org.register.repository.VisibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VisibleServiceImpl implements VisibleService{

	@Autowired
	private VisibleRepository visibleRepository;
	
	@Transactional
	public List<Visible> getVisibleList() {
		return visibleRepository.findAll();
		
	}

}
