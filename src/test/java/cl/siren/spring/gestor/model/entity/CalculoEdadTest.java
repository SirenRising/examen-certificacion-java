package cl.siren.spring.gestor.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculoEdadTest {
	
	private List<String> detalle;
	private CalculoEdad calculoEdad = new CalculoEdad();
	
	void initList(String edad) {
		this.detalle = new ArrayList<String>();
		this.detalle.add(edad);
	}
	
	@Test
	void pruebasDeBorde() {
		initList("-1");
		assertEquals(0.0, this.calculoEdad.descuento(this.detalle));
		
		initList("60");
		assertNotEquals(0.3, this.calculoEdad.descuento(this.detalle));

		initList("60");
		assertEquals(0.0, this.calculoEdad.descuento(this.detalle));
	}
	
	@Test
	void pruebasDeRango() {
		// Rango 1
		initList("1");
		assertEquals(0.05, this.calculoEdad.descuento(this.detalle));

		initList("3");
		assertNotEquals(0.1, this.calculoEdad.descuento(this.detalle));
		
		initList("5");
		assertEquals(0.05, this.calculoEdad.descuento(this.detalle));

		// Rango 2
		initList("6");
		assertEquals(0.03, this.calculoEdad.descuento(this.detalle));

		initList("10");
		assertNotEquals(0.05, this.calculoEdad.descuento(this.detalle));
		
		initList("12");
		assertEquals(0.03, this.calculoEdad.descuento(this.detalle));

		// Rango 3
		initList("13");
		assertEquals(0.0, this.calculoEdad.descuento(this.detalle));

		initList("25");
		assertNotEquals(0.4, this.calculoEdad.descuento(this.detalle));
		
		initList("35");
		assertEquals(0.0, this.calculoEdad.descuento(this.detalle));

		// Rango 4
		initList("36");
		assertEquals(0.1, this.calculoEdad.descuento(this.detalle));

		initList("45");
		assertNotEquals(0.5, this.calculoEdad.descuento(this.detalle));
		
		initList("59");
		assertEquals(0.1, this.calculoEdad.descuento(this.detalle));

		
		// Rango 5
		initList("61");
		assertEquals(0.3, this.calculoEdad.descuento(this.detalle));

		initList("75");
		assertNotEquals(0.1, this.calculoEdad.descuento(this.detalle));
		
		initList("90");
		assertEquals(0.3, this.calculoEdad.descuento(this.detalle));

	}
	
}
