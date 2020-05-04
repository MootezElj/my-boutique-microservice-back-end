package com.targa.labs.myBoutique.customer.web;

import com.targa.labs.myBoutique.commons.dto.CartDto;
import com.targa.labs.myBoutique.commons.dto.OrderDto;
import com.targa.labs.myBoutique.customer.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myBoutique.commons.utils.Web.API;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/carts")
public class CartResourse {

	private final CartService cartService;
	@GetMapping
	public List<CartDto> findAll() {
		return this.cartService.findAll();
	}

	@GetMapping("/active")
	public List<CartDto> findAllActiveCarts() {
		return this.cartService.findAllActiveCarts();
	}

	@GetMapping("/customer/{id}")
	public CartDto getActiveCartForCustomer(@PathVariable("id") Long customerId) {
		return this.cartService.getActiveCart(customerId);
	}

	@GetMapping("/customer")
	public CartDto getActiveCartForCustomer(@RequestParam("username") String customerUsername) {
		return this.cartService.getActiveCart(customerUsername);
	}


	@GetMapping("/{id}")
	public CartDto findById(@PathVariable Long id) {
		return this.cartService.findById(id);
	}


	@GetMapping("/Anonym")
	public CartDto findAnonymCartByToken(@RequestHeader("CartToken") String CartToken) {
		return this.cartService.getCartByToken(CartToken);
	}

	@PostMapping("/customer/{username}")
	public CartDto create(@PathVariable("username") String username) {
		return this.cartService.create(username);
	}

	@PostMapping()
	public String createAnonymusCart() {
		return this.cartService.createAnonym();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.cartService.delete(id);
	}

	//Anonym Cart
	@PutMapping("/AddProduct/{productId}")
	public OrderDto addProductToOrder(@RequestHeader("CartToken") String CartToken,@PathVariable Long productId ){
		return this.cartService.addProductToCart(CartToken,productId);
	}

	@PutMapping("/AddProduct/{cartId}/{productId}")
	public OrderDto addProductToOrder(@PathVariable Long cartId,@PathVariable Long productId ){
		return this.cartService.addProductToCart(cartId,productId);
	}

	@PutMapping("/AssignCartToCustomer/{cartId}/{username}")
	public CartDto assignCustomerToCart(@PathVariable Long cartId,@PathVariable String username){
		return this.cartService.assignCartToCustomer(cartId,username);
	}

	@PutMapping("/AssignAnonymCartToCustomer/{username}")
	public CartDto assignCustomerToCart(@RequestHeader("CartToken") String CartToken,@PathVariable String username){
		return this.cartService.assignAnonymCartToUser(CartToken,username);
	}
}