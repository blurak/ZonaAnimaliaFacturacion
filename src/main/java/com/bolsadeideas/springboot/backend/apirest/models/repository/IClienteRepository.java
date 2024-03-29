package com.bolsadeideas.springboot.backend.apirest.models.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Region;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
	@Query("from Region")
	public List<Region> findAllRegiones();
	//public Cliente getByemail(String email);
}
