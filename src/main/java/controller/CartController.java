package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Clinica_Medica.Clinica.entity.Cart;
import service.ServiceCart;

@RestController
@RequestMapping("/cart")
public class CartController {

	private ServiceCart serviceCart;
	
  @GetMapping("/cart")
  public List <Cart> consultCart(){
	return serviceCart.ListItens();
	
	
}

	
	
	
	
}
