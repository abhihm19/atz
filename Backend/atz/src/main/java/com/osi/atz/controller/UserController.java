package com.osi.atz.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.atz.dto.ApiResponse;
import com.osi.atz.dto.SignUpRequest;
import com.osi.atz.model.User;
import com.osi.atz.repository.UserRepository;
import com.osi.atz.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api/v1")
public class UserController {
	
	private IUserService userService;	
	private UserRepository userRepository;	
	
	public UserController(IUserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}

	@PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody SignUpRequest signUpRequest) {
    	System.out.println(signUpRequest);
    	Optional<User> userWithEmail = userRepository.findByEmailId(signUpRequest.getEmailId());
    	Optional<User> userWithUsername = userRepository.findByUsername(signUpRequest.getUsername());
    	if (userWithEmail.isPresent() || userWithUsername.isPresent()) {
			return ResponseEntity
					.badRequest()
					.body(new ApiResponse(false,"Username or Email Id is already taken!"));
		}
    	
    	userService.saveUser(signUpRequest);
    	return ResponseEntity.ok().body(new ApiResponse(true,"User registered successfully!"));
    }

}
