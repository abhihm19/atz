package com.osi.atz.service;

import org.springframework.stereotype.Service;

import com.osi.atz.dto.UserDetailDto;
import com.osi.atz.model.UserDetail;
import com.osi.atz.repository.UserDetailRepository;

@Service
public class UserDetailServiceImpl implements IUserDetailService {
	
	private UserDetailRepository userDetailRepository;	

	public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
		super();
		this.userDetailRepository = userDetailRepository;
	}

	@Override
	public String updateUserDetail(UserDetailDto userDetailDto, int userDetailId) {
		UserDetail userDetail = userDetailRepository.findById(userDetailId)
				.orElseThrow(() -> new RuntimeException("User not linked with user details"));
		userDetail.setFirstName(userDetailDto.getFirstName());
		userDetail.setLastName(userDetailDto.getLastName());
		userDetail.setMobileNo(userDetailDto.getMobileNo());
		userDetail.setCurrentLocation(userDetailDto.getCurrentLocation());
		userDetail.setGender(userDetailDto.getGender());
		userDetail.setUniversityName(userDetailDto.getUniversityName());
		userDetail.setGraduationYear(userDetailDto.getGraduationYear());
		userDetail.setDegree(userDetailDto.getDegree());
		userDetailRepository.save(userDetail);
		
		return "User details saved successfully";
	}

	@Override
	public UserDetailDto viewUserDetail(int userDetailId) {
		UserDetail userDetail = userDetailRepository.findById(userDetailId)
				.orElseThrow(() -> new RuntimeException("User not linked with user details"));
		UserDetailDto userDetailDto = new UserDetailDto();
		userDetailDto.setFirstName(userDetail.getFirstName());
		userDetailDto.setLastName(userDetail.getLastName());
		userDetailDto.setMobileNo(userDetail.getMobileNo());
		userDetailDto.setCurrentLocation(userDetail.getCurrentLocation());
		userDetailDto.setGender(userDetail.getGender());
		userDetailDto.setUniversityName(userDetail.getUniversityName());
		userDetailDto.setGraduationYear(userDetail.getGraduationYear());
		userDetailDto.setDegree(userDetail.getDegree());
		
		return userDetailDto;
	}

	@Override
	public String deleteUserDetail(int userDetailId) {
		UserDetail userDetail = userDetailRepository.findById(userDetailId)
				.orElseThrow(() -> new RuntimeException("User not linked with user details"));
		userDetailRepository.delete(userDetail);
		
		return "User details deleted successfully";
	}

}
