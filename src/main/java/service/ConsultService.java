package service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Clinica_Medica.Clinica.entity.Consult;
import com.Clinica_Medica.Clinica.entity.Doctor;
import com.Clinica_Medica.Clinica.entity.resources.InvalidConsultExecption;
import com.Clinica_Medica.Clinica.repository.ConsultRepository;

@Service
public class ConsultService {
	
	

	@Autowired
	private ConsultRepository consultRepository;
	
	private void validateConsult(Consult consult) {
		LocalTime consultTime = consult.getTime();
		if (consultTime.isBefore(LocalTime.of(9, 0))|| consultTime.isAfter(LocalTime.of(17,0))){
			throw new InvalidConsultExecption("A consulta deve estar entra as 9:00 as 17:00");
		}
	   if(!consult.getTime().plusMinutes(30).isBefore(LocalTime.of(17,0))){
		   
	   
		   throw new InvalidConsultExecption("A consulta deve estar entra as 9:00 as 17:00");
	}
	
	
	}
	 private void verifyAvailability(Consult consult) {
		 LocalDate consultDate = consult.getDate();
		 LocalTime consultTime = consult.getTime();
		 Doctor doctor = consult.getDoctor();
		 
		 List<Consult> consultInSameDay = consultRepository.findByDateandDoctor(consultDate, doctor);
		 for(Consult existingConsult : consultInSameDay){
			 LocalTime  existingTime = existingTime = existingConsult.getTime();
			 
			 if(Math.abs(ChronoUnit.MINUTES.between(existingTime, consultTime)) <30){
				 throw new InvalidConsultExecption("O medico ja possui consulta masrcada neste horario");
				 
			 }
		 }
			 
	 }
	 
	 public Consult scheduleAppointment(Consult consult){
		 
		 validateConsult(consult);
		 verifyAvailability(consult);
		 return consultRepository.save(consult);
		 
	 }
	 
	 public List<Consult> consultList(){
		 
		return consultRepository.findAll();
		 
	 }
}
