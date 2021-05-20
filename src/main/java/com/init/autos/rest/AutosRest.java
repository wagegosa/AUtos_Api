package com.init.autos.rest;

import java.util.List;
import java.util.Optional;

import javax.sound.midi.Patch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.autos.dao.AutosDAO;
import com.init.autos.entitys.Auto;

@RestController
@RequestMapping("autos")
public class AutosRest {

	private AutosDAO autoDAO;
	
	// Muestra todo en una lista
	@GetMapping
	public ResponseEntity<List<Auto>> getAuto(){
		List<Auto> autos= autoDAO.findAll();
		return ResponseEntity.ok(autos);
		
	}
	// Muestra consulta aun id
	@RequestMapping(value = "{autoId}") 
	public ResponseEntity<Auto> getAutoById(@PathVariable("autoId") Long autoId){
		Optional<Auto> optionalAuto = autoDAO.findById(autoId);
		if(optionalAuto.isPresent()) {
			return ResponseEntity.ok(optionalAuto.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	// Para Insertar
	@PostMapping
	public ResponseEntity<Auto> createAuto(@RequestBody Auto auto){
		Auto newAuto = autoDAO.save(auto);
		return ResponseEntity.ok(newAuto);
	}
	
	// Para Actualizar
	@PutMapping
	public ResponseEntity<Auto> updateAuto(@RequestBody Auto auto){
		Optional<Auto> optionalAuto = autoDAO.findById(auto.getId_automovil());
		if(optionalAuto.isPresent()) {
			Auto updateAuto = optionalAuto.get();
			updateAuto.setMarca_Auto(auto.getMarca_Auto());
			updateAuto.setColor(auto.getColor());
			updateAuto.setNumero_pasajeros(auto.getNumero_pasajeros());
			updateAuto.setPlaca(auto.getPlaca());
			autoDAO.save(updateAuto);
			return ResponseEntity.ok(updateAuto);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//@GetMapping
	//@RequestMapping(value = "Hello", method = RequestMethod.GET)
	public String hello() {
		return "Hola Mundo";
	}
}
