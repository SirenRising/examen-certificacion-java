package cl.siren.spring.gestor.model.entity;

import java.util.List;

import cl.siren.spring.gestor.interfaces.ICalculoDescuento;

public class CalculoEdad implements ICalculoDescuento {

	@Override
	public double descuento(List<String> detalle) {
		int edad = Integer.valueOf(detalle.get(0));
		double desct = 0.0;
		
		if((edad >= 0) && (edad <= 5)) {
			desct = 0.05;
		} else {
			if((edad > 5) && (edad < 13)) {
				desct = 0.03;
			} else {
				if((edad >= 13) && (edad <= 35)) {
					desct = 0.0;
				} else {
					if((edad > 35) && (edad < 60)) {
						desct = 0.1;
					} else {
						if(edad > 60) {
							desct = 0.3;
						}						
					}					
				}				
			}			
		}
		
		return desct;
	}

}
