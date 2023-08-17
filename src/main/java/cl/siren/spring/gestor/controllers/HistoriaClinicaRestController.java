package cl.siren.spring.gestor.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.siren.spring.gestor.model.entity.HistoriaClinica;
import cl.siren.spring.gestor.model.services.HistoriaClinicaService;

@RestController
@RequestMapping(
	path = "/api/historiaClinica",	
	produces = MediaType.APPLICATION_JSON_VALUE
)
public class HistoriaClinicaRestController {

	@Autowired
	HistoriaClinicaService historiaClinicaService;
	
	@GetMapping
	public ResponseEntity<String> status(){
		LocalDateTime timestamp = LocalDateTime.now();
		return ResponseEntity.status(HttpStatus.OK).body(timestamp+ ": API corriendo");
	}
	
	@PostMapping(
		path = "/crear",
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<HistoriaClinica> crear(@RequestBody HistoriaClinica historiaClinica, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(historiaClinicaService.crearHistoriaClinica(historiaClinica));
		
	}
	
	@GetMapping(path = "/buscar")
	public ResponseEntity<HistoriaClinica> buscar(@RequestParam int id, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(historiaClinicaService.buscarHistoriaClinica(id));
		
	}
	
	@PutMapping(
			path = "/actualizar",
			consumes = MediaType.APPLICATION_JSON_VALUE
		)
	public ResponseEntity<HistoriaClinica> actualizar(@RequestBody HistoriaClinica historiaClinica, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(historiaClinicaService.actualizarHistoriaClinica(historiaClinica));
		
	}
	
	@DeleteMapping(path = "/eliminar")
	public ResponseEntity<String> eliminar(@RequestParam int id, HttpServletRequest request){
		historiaClinicaService.eliminarHistoriaClinica(id);
		return ResponseEntity.status(HttpStatus.OK).body("Hstoria clinica eliminada");
		
	}
}
