package service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Clinica_Medica.Clinica.entity.Consult;
import com.Clinica_Medica.Clinica.entity.Doctor;
import com.Clinica_Medica.Clinica.entity.Patient;
import com.Clinica_Medica.Clinica.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicePatient {
	
@Autowired
private PatientRepository patientRepository;

 public Patient  creatPatient(Patient patient) {
	 
	 return patientRepository.save(patient);
 }
 public void deletePatient(Long idPatient) {
   patientRepository.deleteById(idPatient);
}
 
 public List<Patient> listPatient(){
	 return patientRepository.findAll();
 }
 
 public Patient findPatientById(Long idPatient) {
	 
	 return patientRepository.findById(idPatient)
    .orElseThrow(()-> new EntityNotFoundException("Pacinte não rncontrado"));
	 
 }
  
 public Patient updatePatient(Long idPatient, Patient updatedPatient) {

	  Patient patient = findPatientById(idPatient);
	  patient.setName(updatedPatient.getName());
	  patient.setBirthday(updatedPatient.getBirthday());
	  patient.setInsurance(updatedPatient.getInsurance());
	  patient.setCpf(updatedPatient.getCpf());
	  return patientRepository.save(patient);
	
 }
 


}
