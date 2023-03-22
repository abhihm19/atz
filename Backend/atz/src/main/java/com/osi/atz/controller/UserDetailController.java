package com.osi.atz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.atz.dto.ApiResponse;
import com.osi.atz.dto.UserDetailDto;
import com.osi.atz.service.IUserDetailService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api/v1/{username}/user")
public class UserDetailController {

	private IUserDetailService userDetailService;

	public UserDetailController(IUserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}

	@PutMapping("/{userDetailId}")
    public ResponseEntity<ApiResponse> updateUserDetail(@RequestBody UserDetailDto userDetailDto, @PathVariable int userDetailId) {
		String output = userDetailService.updateUserDetail(userDetailDto, userDetailId);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	
	@GetMapping("/{userDetailId}")
    public ResponseEntity<UserDetailDto> viewUserDetail(@PathVariable int userDetailId) {
		UserDetailDto userDetailDto = userDetailService.viewUserDetail(userDetailId);
    	return ResponseEntity.ok().body(userDetailDto);	
	}
	
	@DeleteMapping("/{userDetailId}")
    public ResponseEntity<ApiResponse> deleteUserDetail(@PathVariable int userDetailId) {
		String output = userDetailService.deleteUserDetail(userDetailId);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}

}
