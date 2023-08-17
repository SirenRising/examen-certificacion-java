package cl.siren.spring.gestor.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="historia_clinica")
public class HistoriaClinica {

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="Paciente_ID")
	private int pacienteId;
    
	@Column(name="Doctor_ID")
	private int doctorId;
	
	@Column(name="Fecha_Cita")
    private Date fechaCita;
	
	@Column(name="Sintomas")
    private String sintomas;
    
	@Column(name="Diagnostico") 
	private String diagnostico;
    
	@Column(name="Tratamiento")
	private String tratamiento;

	public HistoriaClinica() {}

	public HistoriaClinica(int id, int pacienteId, int doctorId, Date fechaCita, String sintomas, String diagnostico,
			String tratamiento) {
		this.id = id;
		this.pacienteId = pacienteId;
		this.doctorId = doctorId;
		this.fechaCita = fechaCita;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	@Override
	public String toString() {
		return "HistoriaClinica [id=" + id + ", pacienteId=" + pacienteId + ", doctorId=" + doctorId + ", fechaCita="
				+ fechaCita + ", sintomas=" + sintomas + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento
				+ "]";
	}	
    
}
