package com.Clinica_Medica.Clinica.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Consult consult;
	
	private BigDecimal value;
	
	public Cart(Consult consult,BigDecimal value) {
		

		this.consult = consult;
		this.value = value;
	}

	public Consult getConsult() {
		return consult;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public BigDecimal getValue() {
		return value;
	}
	
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	
}
