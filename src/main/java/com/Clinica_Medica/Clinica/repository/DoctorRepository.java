package com.Clinica_Medica.Clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Clinica_Medica.Clinica.entity.Doctor;

public interface DoctorRepository extends JpaRepository <Doctor ,Long> {

}
