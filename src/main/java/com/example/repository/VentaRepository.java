package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Venta;

@Repository
@Transactional
public interface VentaRepository extends CrudRepository<Venta, Integer>{

	List<Venta> findByTipoestrenoOrderByMontopagoAsc(String tipolibro);
	
	
	@Query("select v from Venta v where v.montopago between ?1 and ?2")
	List<Venta> findByMontopago(double mp1, double mp2);
}
