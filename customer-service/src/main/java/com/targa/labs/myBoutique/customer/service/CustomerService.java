package com.targa.labs.myBoutique.customer.service;

import com.targa.labs.myBoutique.commons.dto.CustomerDto;
import com.targa.labs.myBoutique.customer.domain.Customer;
import com.targa.labs.myBoutique.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class CustomerService {

	private final CustomerRepository customerRepository;

	RestTemplate restTemplate ;
	@Transactional
	public CustomerDto create(CustomerDto customerDto) {
		log.debug("Request to create Customer : {}", customerDto);
		return mapToDto(
				this.customerRepository.save(
						new Customer(null,
								customerDto.getFirstName(),
								customerDto.getLastName(),
								customerDto.getUsername(),
								customerDto.getEmail(),
								customerDto.getPhone(),
								Collections.emptySet(),
								Boolean.TRUE
								)
						)
				);
	}




	public List<CustomerDto> findAll() {
		log.debug("Request to get all Customers");
		return this.customerRepository.findAll()
				.stream()
				.map(CustomerService::mapToDto)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CustomerDto findById(Long id) {
		log.debug("Request to get Customer : {}", id);
		return this.customerRepository.findById(id).map(CustomerService::mapToDto).orElse(null);
	}

	@Transactional(readOnly = true)
	public CustomerDto findByEmail(String email) {
		log.debug("Request to get Customer by email: {}", email);
		return this.customerRepository.findByEmail(email).map(CustomerService::mapToDto).orElse(null);
	}

	public List<CustomerDto> findAllActive() {
		log.debug("Request to get all Customers");
		return this.customerRepository.findAllByEnabled(true)
				.stream()
				.map(CustomerService::mapToDto)
				.collect(Collectors.toList());
	}

	public List<CustomerDto> findAllInactive() {
		log.debug("Request to get all Customers");
		return this.customerRepository.findAllByEnabled(false)
				.stream()
				.map(CustomerService::mapToDto)
				.collect(Collectors.toList());
	}

	public CustomerDto findActiveCustomerByUsername(String username){
		return this.mapToDto(this.customerRepository.findByUsernameAndEnabled(username,true));
	}

	public void delete(Long id) {
		log.debug("Request to delete Customer : {}", id);

		Customer customer = this.customerRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));

		customer.setEnabled(false);
		this.customerRepository.save(customer);
	}

	public static CustomerDto mapToDto(Customer customer) {
		if (customer != null) {
			return new CustomerDto(
					customer.getId(),
					customer.getFirstName(),
					customer.getLastName(),
					customer.getEmail(),
					customer.getPhone(),
					customer.getUsername()
					);
		}
		return null;
	}


	public String createUserIfUserExistent() {


		String response = restTemplate.exchange("http://jwt-auth-service/api/jwt/test/",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
		return  response;

	}

}