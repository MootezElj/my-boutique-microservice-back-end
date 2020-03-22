package com.labs.targa.auth.security.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.labs.targa.auth.security.JwtProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.labs.targa.auth.security.domain.User;
import com.labs.targa.auth.security.service.UserService;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jwt")
public class UserResource {

	private final UserService userService;

//	@GetMapping("/currentUser")
//	public User getUserInfoAfterLogin() {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null) {
//			String name = auth.getName();
//			return this.userService.getUserByUsername(name);
//		}
//		return null;
//
//	}


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







}
