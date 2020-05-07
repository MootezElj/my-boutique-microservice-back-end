package com.targa.labs.myBoutique.order.service;

import com.targa.labs.myBoutique.commons.dto.AddressDto;
import com.targa.labs.myBoutique.commons.dto.CartDto;
import com.targa.labs.myBoutique.commons.dto.OrderDto;
import com.targa.labs.myBoutique.order.domain.Address;
import com.targa.labs.myBoutique.order.domain.Order;
import com.targa.labs.myBoutique.order.domain.OrderItem;
import com.targa.labs.myBoutique.order.domain.enumeration.OrderStatus;
import com.targa.labs.myBoutique.order.repository.OrderItemRepository;
import com.targa.labs.myBoutique.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class OrderService {
	private final OrderRepository orderRepository;
	private final OrderItemRepository orderItemRepository;
	public List<OrderDto> findAll() {
		log.debug("Request to get all Orders");
		return this.orderRepository.findAll()
				.stream()
				.map(OrderService::mapToDto)
				.collect(Collectors.toList());
	}


	@Transactional(readOnly = true)
	public OrderDto findById(Long id) {
		log.debug("Request to get Order : {}", id);
		return this.orderRepository.findById(id).map(OrderService::mapToDto).orElse(null);
	}


	//done
	public OrderDto create(OrderDto orderDto) {
		log.debug("Request to create Order : {}", orderDto);
		return mapToDto(
				this.orderRepository.save(
						new Order(
								BigDecimal.ZERO,
								OrderStatus.CREATION,
								null,
								null,
								null,
								Collections.emptySet(),
								null
								)
						)
				);
	}

	public OrderDto addProductToOrder(Long orderId,Long productId){

		OrderItem orderItem = this.orderItemRepository.findByProductIdAndOrderId(productId,orderId);
		Order order=this.orderRepository.findById(orderId).get();
		if (orderItem!=null){
			orderItem.setQuantity(orderItem.getQuantity()+1);
		}
		else {
			orderItem = new OrderItem(1l,productId,order);
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		orderItemRepository.save(orderItem);
		return this.mapToDto(this.orderRepository.save(order));
	}

	public OrderDto create(CartDto cart) {
		log.debug("Request to create with a cart : {}", cart);
		return this.mapToDto(this.orderRepository
				.save(new Order(
						BigDecimal.ZERO,
						OrderStatus.CREATION,
						null,
						null,
						null,
						Collections.emptySet(),
						cart.getId())));
	}

	public OrderDto updateOrderAddress(Long orderId,AddressDto addressDto){
		Order order = this.orderRepository.findById(orderId).get();
		if (order!=null){
			order.setShipmentAddress(new Address(addressDto.getAddress1(),
					addressDto.getAddress2()
					,addressDto.getCity()
					,addressDto.getPostcode()
			,addressDto.getCountry()));
			return this.mapToDto(this.orderRepository.save(order));
		}
		return null;
	}


	public void delete(Long id) {
		log.debug("Request to delete Order : {}", id);
		this.orderRepository.deleteById(id);
		}

	public static OrderDto mapToDto(Order order) {
		if (order != null) {
			return new OrderDto(
					order.getId(),
					order.getTotalPrice(),
					order.getStatus().name(),
					order.getShipped(),
					PaymentService.mapToDto(order.getPayment()),
					AddressService.mapToDto(order.getShipmentAddress())
					);
		}
		return null;
	}


}
