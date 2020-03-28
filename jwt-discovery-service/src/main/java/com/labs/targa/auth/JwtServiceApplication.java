package com.labs.targa.auth;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.labs.targa.auth.security.domain.User;
import com.labs.targa.auth.security.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class JwtServiceApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public static void main(String[] args) {
		SpringApplication.run(JwtServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		// Delete all
//        this.userRepository.deleteAll();

        // Crete users
        User dan = new User("user","user@gmail.com",passwordEncoder.encode("user"),"USER","");
        User admin = new User("admin","admin@gmail.com",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager","manager@gmail.com",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(dan,admin,manager);

        // Save to db
        System.out.println("Saving users To DB");
        if (userRepository.findAll().isEmpty())
        this.userRepository.saveAll(users);
	}

}

