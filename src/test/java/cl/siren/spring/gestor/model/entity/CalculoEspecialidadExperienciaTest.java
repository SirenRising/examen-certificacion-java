package cl.siren.spring.gestor.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculoEspecialidadExperienciaTest {
	
	private List<String> detalle;
	private CalculoEspecialidadExperiencia calculoEspecialidadExperiencia = new CalculoEspecialidadExperiencia();
	
	void initList(String spec, String exp) {
		this.detalle = new ArrayList<String>();
		this.detalle.add(spec);
		this.detalle.add(exp);
	}
	
	@Test
	void pruebasDeBorde() {
		initList("Dermatología", "10");
		assertEquals(0.0, this.calculoEspecialidadExperiencia.descuento(this.detalle));
		
		initList("Cardiología", "5");
		assertNotEquals(0.3, this.calculoEspecialidadExperiencia.descuento(this.detalle));

		initList("Cardiología", "10");
		assertEquals(0.0, this.calculoEspecialidadExperiencia.descuento(this.detalle));
	}
	
	@Test
	void pruebasDeRango() {		
		initList("Cardiología", "15");
		assertEquals(0.05, this.calculoEspecialidadExperiencia.descuento(this.detalle));

		initList("Neurología", "7");
		assertNotEquals(0.1, this.calculoEspecialidadExperiencia.descuento(this.detalle));
		
		initList("Endocrinología", "3");
		assertEquals(0.1, this.calculoEspecialidadExperiencia.descuento(this.detalle));

		initList("Oncología", "9");
		assertNotEquals(0.03, this.calculoEspecialidadExperiencia.descuento(this.detalle));

		initList("Dermatología", "20");
		assertEquals(0.0, this.calculoEspecialidadExperiencia.descuento(this.detalle));
		
	}
	
}
