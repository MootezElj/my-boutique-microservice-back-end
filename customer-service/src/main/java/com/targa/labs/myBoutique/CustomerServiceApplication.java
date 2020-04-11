package com.targa.labs.myBoutique;

import com.targa.labs.myBoutique.customer.domain.Customer;
import com.targa.labs.myBoutique.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
public class CustomerServiceApplication  implements CommandLineRunner {
	@Autowired
	CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.customerRepository.save(new Customer("Mootez","Elj","admin","admin@gmail.com","51906322",true));
	}
}
