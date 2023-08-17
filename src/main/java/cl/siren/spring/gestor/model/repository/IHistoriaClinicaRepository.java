package cl.siren.spring.gestor.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.siren.spring.gestor.model.entity.HistoriaClinica;

public interface IHistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer> {

}
