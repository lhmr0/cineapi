package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Venta;
import com.example.repository.VentaRepository;

import com.example.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository ventaRepository;
	
	
	@Override
	public Venta findById(int id) {
		// TODO Auto-generated method stub
		return ventaRepository.findOne(id);
	}

	@Override
	public void saveVenta(Venta venta) {
		// TODO Auto-generated method stub
		calcularMontopago(venta);
		ventaRepository.save(venta);
	}

	@Override
	public void updateVenta(Venta venta) {
		// TODO Auto-generated method stub
		calcularMontopago(venta);
		ventaRepository.save(venta);
	}

	@Override
	public void deleteVenta(int id) {
		// TODO Auto-generated method stub
		ventaRepository.delete(id);
	}

	@Override
	public Iterable<Venta> findAllVenta() {
		// TODO Auto-generated method stub
		return ventaRepository.findAll();
	}

	@Override
	public Iterable<Venta> findByTipoestrenoOrderByMontopagoAsc(String tipoestreno) {
		// TODO Auto-generated method stub
		return ventaRepository.findByTipoestrenoOrderByMontopagoAsc(tipoestreno);
	}

	@Override
	public Iterable<Venta> findByMontopago(double mp1, double mp2) {
		// TODO Auto-generated method stub
		return ventaRepository.findByMontopago(mp1, mp2);
	}
	
	
	private double calcularMontopago(Venta v){
		double montopagar=0.0;
		
		if(v.getTipoestreno().equals("E")){
			if(v.getTipopago().equals("TARJETA")){
			montopagar=(18*v.getCantidad())*1.18;
		}else{
			montopagar=18*v.getCantidad();
		}
		}
		
		
		
		if(v.getTipoestreno().equals("N")){
			if(v.getTipopago().equals("TARJETA")){
				montopagar=(12*v.getCantidad())*1.18;
			}else{
				montopagar=12*v.getCantidad();
			}
			
		}	
		
		
		v.setMontopago(montopagar);
		
		return montopagar;
	}

}