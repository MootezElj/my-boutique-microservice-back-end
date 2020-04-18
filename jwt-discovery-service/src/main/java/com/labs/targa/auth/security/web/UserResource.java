package com.labs.targa.auth.security.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.labs.targa.auth.security.JwtProperties;
import com.labs.targa.auth.security.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.labs.targa.auth.security.domain.User;
import com.labs.targa.auth.security.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jwt")
public class UserResource {

	private final UserService userService;

	private DiscoveryClient discoveryClient;

    @GetMapping("/currentUser")
	public User getUserInfoAfterLogin(HttpServletRequest request) {
		//request.getSession(true);
		String st = request.getHeader("Authorization");
		HttpSession session = request.getSession();
		Principal principal = request.getUserPrincipal();
		return this.userService.getUserByUsername(principal.getName());

	}

    @GetMapping("/test")
    public String test() {
        return "You are authorized here";
    }


	@PostMapping("/register-customer")
	public UserDto showRegistrationForm (@RequestBody  UserDto userDto) throws Exception {
		return this.userService.registerNewUserAccount(userDto,"CUSTOMER");
	}
}
