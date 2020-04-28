package com.targa.labs.myBoutique.customer.service;


import com.targa.labs.myBoutique.commons.dto.CartDto;
import com.targa.labs.myBoutique.commons.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;


@FeignClient(name = "order-service")
public interface OrderServiceClient {

    @RequestMapping(value = "/api/orders", method = POST)
    OrderDto create(CartDto cartDto);

    @RequestMapping(value = "/api/orders/AddProduct/{orderId}/{productId}", method = PUT )
    OrderDto addProductToOrder(@PathVariable  Long orderId,@PathVariable Long productId);
}