package org.register.repository;

import java.util.List;

import org.register.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {

	
	public List<Registro> findByName(String name);
	
	@Query("SELECT r FROM Registro r WHERE r.idVisible = :idVisible ")
	public List<Registro> findByVisible(@Param("idVisible") Integer state);
	
	
}
