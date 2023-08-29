package com.Clinica_Medica.Clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Clinica_Medica.Clinica.entity.Cart;

public interface CartRepository extends JpaRepository <Long , Cart> {

	
	
}
