package cl.siren.spring.gestor.model.entity;

import java.util.List;

import cl.siren.spring.gestor.interfaces.ICalculoDescuento;

public class CalculoEspecialidadExperiencia implements ICalculoDescuento {

	@Override
	public double descuento(List<String> detalle) {
		String spec = detalle.get(0).toLowerCase();
		int exp = Integer.valueOf(detalle.get(1));
		double desct = 0.0;
		
		switch (spec) {
		case "cardiología":
			if((exp > 0) && (exp < 10)) {
				desct = 0.15;
			} else {
				if((exp > 10) && (exp <= 20)) {
					desct = 0.05;
				} else {
					if(exp > 20) {
						desct = 0.05;
					}
				}
			}
			break;
			
		case "neurología":
			if((exp > 0) && (exp < 10)) {
				desct = 0.15;
			} else {
				if((exp > 10) && (exp <= 20)) {
					desct = 0.05;
				} else {
					if(exp > 20) {
						desct = 0.05;
					}
				}
			}
			break;
			
		case "endocrinología":
			if((exp > 0) && (exp <= 5)) {
				desct = 0.1;
			} else {
				if((exp > 5) && (exp <= 20)) {
					desct = 0.1;
				} else {
					if(exp > 20) {
						desct = 0.05;
					}
				}
			}
			break;
			
		case "oncología":
			if((exp > 0) && (exp <= 5)) {
				desct = 0.1;
			} else {
				if((exp > 5) && (exp <= 20)) {
					desct = 0.1;
				} else {
					if(exp > 20) {
						desct = 0.05;
					}
				}
			}			
			break;
			
		case "dermatología":
			desct = 0.0;
			
			break;
			
		}
		
		return desct;
		
	}

}
