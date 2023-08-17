import java.util.ArrayList;
import java.util.List;

import cl.siren.spring.gestor.model.entity.CalculoEdad;
import cl.siren.spring.gestor.model.entity.CalculoEspecialidadExperiencia;

public class Main {

	private static List<String> detalle;
	
	private static List<String> initList(String edad) {
		detalle = new ArrayList<String>();
		detalle.add(edad);
		return detalle;
	}
	
	private static List<String> initList(String spec, String exp) {
		detalle = new ArrayList<String>();
		detalle.add(spec);
		detalle.add(exp);
		return detalle;
	}
	
	private static String porcentajeDescuentoATexto(double porcDesct) {
		return String.valueOf((int) (porcDesct*100))+"% de descuento";
	}
	
	public static void main(String[] args) {
		
		CalculoEdad calculoEdad = new CalculoEdad();
		CalculoEspecialidadExperiencia calculoEspecialidadExperiencia = new CalculoEspecialidadExperiencia();
		String porcDesctTexto;

		System.out.println("Detalle de descuentos: Por edad de paciente");
		System.out.println("Rango 1: Hasta 5 anos, "+porcentajeDescuentoATexto(calculoEdad.descuento(initList("3"))));
		System.out.println("Rango 2: Mas de 5 y menos de 13 anos, "+porcentajeDescuentoATexto(calculoEdad.descuento(initList("7"))));
		System.out.println("Rango 3: Entre 13 y 35, no hay descuento, "+porcentajeDescuentoATexto(calculoEdad.descuento(initList("25"))));
		System.out.println("Rango 4: Mas de 35 y menos de 60 anos, "+porcentajeDescuentoATexto(calculoEdad.descuento(initList("55"))));
		System.out.println("Rango 5: Mas de 60 anos, "+porcentajeDescuentoATexto(calculoEdad.descuento(initList("70"))));
		System.out.println("");
		System.out.println("Detalle de descuentos: Por edad de especialidad y anos de experiencia");
		System.out.println("Todas las especilidades con menos de 10 anos de experiencia, "+porcentajeDescuentoATexto(calculoEspecialidadExperiencia.descuento(initList("Cardiología", "7"))));
		System.out.println("Cardiología y Neurología, con mas de 10 anos y menos de 20 anos, "+porcentajeDescuentoATexto(calculoEspecialidadExperiencia.descuento(initList("Cardiología", "15"))));
		System.out.println("Endocrinología y Oncología, con mas de 5 anos de experiencia, "+porcentajeDescuentoATexto(calculoEspecialidadExperiencia.descuento(initList("Oncología", "15"))));
		System.out.println("Dermatología en ningún momento, posee descuento, "+porcentajeDescuentoATexto(calculoEspecialidadExperiencia.descuento(initList("Dermatología", "7"))));
		System.out.println("Todas las especilidades con mas de 20 anos de exp, "+porcentajeDescuentoATexto(calculoEspecialidadExperiencia.descuento(initList("Cardiología", "21"))));
		
	}

}
