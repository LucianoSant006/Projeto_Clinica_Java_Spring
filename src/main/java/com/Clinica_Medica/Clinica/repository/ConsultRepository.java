package com.Clinica_Medica.Clinica.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Clinica_Medica.Clinica.entity.Consult;
import com.Clinica_Medica.Clinica.entity.Doctor;

public interface ConsultRepository extends JpaRepository <Consult, Long >{
	
	List <Consult> findByDateandDoctor(LocalDate date, Doctor doctor);
	

}
