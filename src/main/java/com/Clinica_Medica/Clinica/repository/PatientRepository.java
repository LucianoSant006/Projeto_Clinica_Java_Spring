package com.Clinica_Medica.Clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Clinica_Medica.Clinica.entity.Patient;

public interface PatientRepository extends JpaRepository <Patient,Long> {

}
