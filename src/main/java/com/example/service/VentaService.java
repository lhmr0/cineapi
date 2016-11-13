package com.example.service;

import com.example.entities.Venta;

public interface VentaService {

	Venta findById(int id);

	void saveVenta(Venta venta);

	void updateVenta(Venta venta);

	void deleteVenta(int id);

	Iterable<Venta> findAllVenta();

	Iterable<Venta> findByTipoestrenoOrderByMontopagoAsc(String tipoestreno);

	Iterable<Venta> findByMontopago(double mp1, double mp2);
}