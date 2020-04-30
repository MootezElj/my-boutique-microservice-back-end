package com.targa.labs.myBoutique.customer.service;

import com.sun.deploy.net.HttpRequest;
import com.targa.labs.myBoutique.commons.dto.CartDto;
import com.targa.labs.myBoutique.commons.dto.OrderDto;
import com.targa.labs.myBoutique.customer.domain.Cart;
import com.targa.labs.myBoutique.customer.domain.Customer;
import com.targa.labs.myBoutique.customer.domain.enumeration.CartStatus;
import com.targa.labs.myBoutique.customer.repository.CartRepository;
import com.targa.labs.myBoutique.customer.repository.CustomerRepository;
import com.targa.labs.myBoutique.customer.utils.MyBoutiqueUtils;
import com.targa.labs.myBoutique.customer.utils.TokenProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.auth0.jwt.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class CartService {

	private final CartRepository cartRepository;
	private final CustomerRepository customerRepository;

	
	private final OrderServiceClient orderService;

	public List<CartDto> findAll() {
		log.debug("Request to get all Carts");
		return this.cartRepository.findAll()
				.stream()
				.map(CartService::mapToDto)
				.collect(Collectors.toList());
	}

	public List<CartDto> findAllActiveCarts() {
		return this.cartRepository.findByStatus(CartStatus.NEW)
				.stream()
				.map(CartService::mapToDto)
				.collect(Collectors.toList());
	}

	public CartDto create(String customerUsername) {
		Customer customer = this.customerRepository.findByUsernameAndEnabled(customerUsername,true);
		if ((this.getActiveCart(customerUsername) == null) && (customer!=null)) {
 				Cart cart = new Cart(
					customer,
					CartStatus.NEW
					);

			Cart c = this.cartRepository.save(cart);
			OrderDto order = this.orderService.create(mapToDto(cart));
			c.setOrderId(order.getId());
			return mapToDto(c);
		} else {
			throw new IllegalStateException("There is already an active cart");
		}
	}

	public CartDto create(Long customerId) {
		if (this.getActiveCart(customerId) == null) {
			Customer customer = this.customerRepository.findById(customerId)
					.orElseThrow(() -> new IllegalStateException("The Customer does not exist!"));

			Cart cart = new Cart(
					customer,
					CartStatus.NEW
			);

			OrderDto order = this.orderService.create(mapToDto(cart));
			cart.setOrderId(order.getId());

			return mapToDto(this.cartRepository.save(cart));
		} else {
			throw new IllegalStateException("There is already an active cart");
		}
	}

	public OrderDto addProductToCart(String token, Long productId){
		Long cartId = MyBoutiqueUtils.getCartIdFromToken(token);
		return this.addProductToCart(cartId,productId);
	}

	public OrderDto addProductToCart(Long cartId, Long productId){
		Cart cart = this.cartRepository.findById(cartId).get();
		return this.orderService.addProductToOrder(cart.getOrderId(),productId);
	}

	public CartDto getCartByToken(String token){
		Long cartId = MyBoutiqueUtils.getCartIdFromToken(token);
		Cart cart = this.cartRepository.findById(cartId).get();
		return this.mapToDto(cart);
	}

	//working
	public String createAnonym(){
		Cart cart = new Cart();
		cart.setStatus(CartStatus.NEW);
		Long id = this.cartRepository.save(cart).getId();
		OrderDto order = this.orderService.create(mapToDto(cart));
		cart.setOrderId(order.getId());
		String jwt = JWT.create()
				.withSubject(id.toString())
				.withIssuer("customer-service-myBoutique")
				.sign(HMAC512(TokenProperties.secret));

		return jwt;
	}


	@Transactional(readOnly = true)
	public CartDto findById(Long id) {
		log.debug("Request to get Cart : {}", id);
		return this.cartRepository.findById(id).map(CartService::mapToDto).orElse(null);
	}

	public void delete(Long id) {
		log.debug("Request to delete Cart : {}", id);
		Cart cart = this.cartRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Cannot find cart with id " + id));

		cart.setStatus(CartStatus.CANCELED);

		this.cartRepository.save(cart);
	}

	public CartDto getActiveCart(Long customerId) {
		List<Cart> carts = this.cartRepository
				.findByStatusAndCustomerId(CartStatus.NEW, customerId);
		if (carts != null) {

			if (carts.size() == 1) {
				return mapToDto(carts.get(0));
			}
			if (carts.size() > 1) {
				throw new IllegalStateException("Many active carts detected !!!");
			}
		}

		return null;
	}

	public CartDto getActiveCart(String customerUsername) {
		List<Cart> carts = this.cartRepository
				.findByStatusAndCustomerUsername(CartStatus.NEW, customerUsername);
		if (carts != null) {

			if (carts.size() == 1) {
				return mapToDto(carts.get(0));
			}
			if (carts.size() > 1) {
				throw new IllegalStateException("Many active carts detected !!!");
			}
		}

		return null;
	}

	public CartDto assignAnonymCartToUser(String cartToken, String customerUsername){
		Long cartId = MyBoutiqueUtils.getCartIdFromToken(cartToken);
		return this.assignCartToCustomer(cartId,customerUsername);
	}


	public CartDto assignCartToCustomer(Long cartId, String customerUsername){
		Cart cart = this.cartRepository.findById(cartId).get();
		Customer customer = this.customerRepository.findByUsernameAndEnabled(customerUsername, true);
		cart.setCustomer(customer);
		return mapToDto(this.cartRepository.save(cart));
	}

	public static CartDto mapToDto(Cart cart) {
		if (cart != null) {
			return new CartDto(
					cart.getId(),
					cart.getOrderId(),
					CustomerService.mapToDto(cart.getCustomer()),
					cart.getStatus().name()
					);
		}
		return null;
	}

	public Cart findCartByUsername(String customerUsername){
		return this.cartRepository.findFirstByCustomerUsername(customerUsername);
	}

}