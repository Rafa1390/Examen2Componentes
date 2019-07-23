package com.cenfotec.examen2V1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.examen2V1.domain.Produccion;

public interface ProduccionRepository extends JpaRepository<Produccion, Long>{
	//List<Produccion> findByid_finca(Long id_finca);
}
