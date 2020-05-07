package com.targa.labs.myBoutique.order.web;

import com.targa.labs.myBoutique.commons.dto.AddressDto;
import com.targa.labs.myBoutique.commons.dto.CartDto;
import com.targa.labs.myBoutique.commons.dto.OrderDto;
import com.targa.labs.myBoutique.commons.dto.OrderItemDto;
import com.targa.labs.myBoutique.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myBoutique.commons.utils.Web.API;

@RestController
@RequiredArgsConstructor
@RequestMapping(API + "/orders")
public class OrderResource {
	private final OrderService orderService;

	@GetMapping
	public List<OrderDto> findAll() {
		return this.orderService.findAll();
	}


	@PutMapping("/AddProduct/{orderId}/{productId}")
	public OrderDto addProductToOrder(@PathVariable Long orderId,@PathVariable Long productId){
		return this.orderService.addProductToOrder(orderId,productId);
	}

	@PutMapping("/UpdAddress/{orderId}")
	public OrderDto updateOrderAddress(@PathVariable Long orderId,@RequestBody AddressDto address){
		return this.orderService.updateOrderAddress(orderId, address);
	}



	@GetMapping("/{id}")
	public OrderDto findById(@PathVariable Long id) {return this.orderService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.orderService.delete(id);
	}

	@PostMapping
	public OrderDto create(@RequestBody  CartDto cartDto){
		return this.orderService.create(cartDto);
	}
}
