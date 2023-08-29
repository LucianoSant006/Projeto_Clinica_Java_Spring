package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Clinica_Medica.Clinica.entity.Cart;
import com.Clinica_Medica.Clinica.entity.Consult;
import com.Clinica_Medica.Clinica.repository.CartRepository;

@Service
public class ServiceCart {
	
	@Autowired
	private CartRepository cartRepository;

	private List<Cart> itens = new ArrayList<>();
	
	public List <Cart> ListItens(){
		return itens;
	}
	
	public void removeIten(Consult consult) {
		itens.removeIf(itens -> itens.getConsult().equals(consult));
	}
	
	public BigDecimal calcTotal() {
		return itens.stream()
				.map(Cart::getValue)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	
}
	
}
