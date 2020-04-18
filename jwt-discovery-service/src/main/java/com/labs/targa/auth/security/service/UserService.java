package com.labs.targa.auth.security.service;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.List;

import com.labs.targa.auth.security.dto.UserDto;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Field;
import org.hibernate.annotations.Target;
import org.hibernate.annotations.Type;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labs.targa.auth.security.UserPrincipal;
import com.labs.targa.auth.security.domain.User;
import com.labs.targa.auth.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Constraint;
import javax.validation.Payload;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private final UserRepository userRepository;
	
	public List<User> getAllUsers() {
		log.debug("request to find all users");
		return userRepository.findAll();
	}
	
	public User findUserById(Long id){
		log.debug("request to find user by Id: {} "+ id);
		return userRepository.findById(id).orElse(null);
	}
	
	public User addUser(User user) {
		log.debug("Request to add a new user:{} "+ user);
		return this.userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		log.debug("Request to delete user with id :{} "+id);
		if (id == null || this.userRepository.findById(id)==null) {
			throw(new  IllegalArgumentException("invalid id"));
		}
		 this.userRepository.deleteById(id);
	}
	
	public String getUserAuthoritiesByUsername(String username) {
		if (username!=null) {
			User user = this.userRepository.findByUsername(username);
			UserPrincipal principal = new UserPrincipal(user);
			System.out.println(principal.getAuthorities().toString());
			return principal.getAuthorities().toString();
		}
		return null;
	}
	
	public User getUserByUsername(String username) {
		if (username!=null) {
			User user = this.userRepository.findByUsername(username);
			return user;
		}
		return null;
	}

	public User getUserByEmail(String email) {
		if (email!=null) {
			User user = this.userRepository.findByEmail(email);
			return user;
		}
		return null;
	}

	@Transactional
	public UserDto registerNewUserAccount(UserDto userDto,String role)
			throws Exception {
	try{
		User u = this.getUserByUsername(userDto.getUsername());
		}
		catch (NullPointerException e){

		}

		if (this.getUserByUsername(userDto.getUsername())!=null){
			throw new Exception(
					"There is an account with that username:"
							+ userDto.getUsername());
		}

		if (this.getUserByEmail(userDto.getEmail())!=null){
			throw new Exception(
					"There is an account with that email address:"
							+ userDto.getEmail());
		}

		if (!userDto.getPassword().equals(userDto.getMatchingPassword()))
		{
			throw new Exception(
					"Passwords don't match:");
		}

		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());
		//ROLE_USER
		user.setRoles(role);
		userRepository.save(user);
		return userDto;
	}

	private boolean emailExists(String email) {
		return userRepository.findByEmail(email) != null;
	}
	
	
	

}
