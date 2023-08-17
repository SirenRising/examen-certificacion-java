package cl.siren.spring.gestor.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.siren.spring.gestor.model.entity.HistoriaClinica;
import cl.siren.spring.gestor.model.repository.IHistoriaClinicaRepository;

@Service
public class HistoriaClinicaService {

	
	public HistoriaClinicaService() {}

	@Autowired
	private IHistoriaClinicaRepository historiaClinicaRepo;
	
	public HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica) {
		return historiaClinicaRepo.save(historiaClinica);
	}
	
	public HistoriaClinica buscarHistoriaClinica(int id) {
		return historiaClinicaRepo.findById(id).get();
	}
	
	public HistoriaClinica actualizarHistoriaClinica(HistoriaClinica historiaClinica) {
		return historiaClinicaRepo.save(historiaClinica);
	}
	
	public void eliminarHistoriaClinica(int id) {
		historiaClinicaRepo.deleteById(id);
	}
	
	public List<HistoriaClinica> listarHistoriasClinicas() {
		return (ArrayList<HistoriaClinica>) historiaClinicaRepo.findAll();
	}
	
}
