package cl.siren.spring.gestor.controllers;

import javax.persistence.PostUpdate;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.siren.spring.gestor.model.RespuestaAPI;
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
	
	
    // Constantes
    // -----------------------------------------------------------------------------------------

    /** Objeto {@link Logger} que contiene los métodos de depuración */
    private static final Logger logger = LogManager.getLogger(HistoriaClinicaRestController.class);

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Hola Mundo!
     * 
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le hace el cliente al {@link HttpServlet}
     * @return un objeto {@link ResponseEntity} con la respuesta a la solicitud
     */
    @GetMapping
    public ResponseEntity<RespuestaAPI> mostrarMensaje(HttpServletRequest request) {
        // Depuración
        logger.info("[API] Solicitud GET: {}", request.getRequestURI());

        // Crear respuesta
        RespuestaAPI respuesta = new RespuestaAPI(HttpStatus.OK, "mostrarMensaje", "Hola Mundo!");

        // Devolver respuesta
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    /**
     * Hola Mundo! (Personalizado)
     * 
     * @param nombre  nombre de la persona
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le hace el cliente al {@link HttpServlet}
     * @return un objeto {@link ResponseEntity} con la respuesta a la solicitud
     */
    @GetMapping(path = "/{nombre}")
    public ResponseEntity<RespuestaAPI> mostrarMensajePersonalizado(@PathVariable String nombre, HttpServletRequest request) {
        // Depuración
        logger.info("[API] Solicitud GET: {}", request.getRequestURI());

        // Crear respuesta
        RespuestaAPI respuesta = new RespuestaAPI(HttpStatus.OK, "mostrarMensajePersonalizado",
                "Hola, " + nombre + "!");

        // Devolver respuesta
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

}
