package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.entities.Venta;
import com.example.service.VentaService;

@RestController
public class VentaRestController {

	@Autowired
	private VentaService ventaService;

	@RequestMapping(value = "/venta", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Venta>> listAllVentas() {
		Iterable<Venta> ventas = ventaService.findAllVenta();
		if (ventas == null) {
			return new ResponseEntity<Iterable<Venta>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Venta>>(ventas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/venta", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Venta venta, UriComponentsBuilder ucBuilder) {

		
		ventaService.saveVenta(venta);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/venta/{id}").buildAndExpand(venta.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/venta/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Venta> updateVenta(@PathVariable("id") int id, @RequestBody Venta venta) {

		Venta currentVenta = ventaService.findById(id);

		if (currentVenta == null) {
			return new ResponseEntity<Venta>(HttpStatus.NOT_FOUND);
		}

		currentVenta.setNombrepelicula(venta.getNombrepelicula());
		currentVenta.setTipoestreno(venta.getTipoestreno());
		currentVenta.setCantidad(venta.getCantidad());
		currentVenta.setTipopago(venta.getTipopago());

		ventaService.updateVenta(currentVenta);
		return new ResponseEntity<Venta>(currentVenta, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/venta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Venta> deleteVenta(@PathVariable("id") int id) {

		Venta venta = ventaService.findById(id);
		if (venta == null) {
			return new ResponseEntity<Venta>(HttpStatus.NOT_FOUND);
		}

		ventaService.deleteVenta(id);
		return new ResponseEntity<Venta>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/venta/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venta> getVenta(@PathVariable("id") int id) {

		Venta venta = ventaService.findById(id);
		if (venta == null) {
			return new ResponseEntity<Venta>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Venta>(venta, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/venta/mp1/{mp1}/mp2/{mp2}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Venta>> getVentaRange(@PathVariable("mp1") double mp1,
			@PathVariable("mp2") double mp2) {

		Iterable<Venta> ventas = ventaService.findByMontopago(mp1, mp2);

		if (ventas == null) {
			return new ResponseEntity<Iterable<Venta>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Venta>>(ventas, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/venta/tipolibro/{tipolibro}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Venta>> getVentaTipoLibro(@PathVariable("tipoestreno") String tipoestreno) {

		Iterable<Venta> ventas = ventaService.findByTipoestrenoOrderByMontopagoAsc(tipoestreno);

		if (ventas == null) {
			return new ResponseEntity<Iterable<Venta>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Venta>>(ventas, HttpStatus.OK);

	}

}
