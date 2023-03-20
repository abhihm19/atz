package com.osi.atz.service;

import org.springframework.stereotype.Service;

import com.osi.atz.dto.SignUpRequest;
import com.osi.atz.model.Company;
import com.osi.atz.model.User;
import com.osi.atz.model.UserDetail;
import com.osi.atz.repository.CompanyRepository;
import com.osi.atz.repository.RoleRepository;
import com.osi.atz.repository.UserDetailRepository;
import com.osi.atz.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private CompanyRepository companyRepository;
	private UserDetailRepository userDetailRepository;	
	
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			CompanyRepository companyRepository, UserDetailRepository userDetailRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.companyRepository = companyRepository;
		this.userDetailRepository = userDetailRepository;
	}

	@Override
	public void saveUser(SignUpRequest signUpRequest) {		
		User user = new User();		
		user.setEmailId(signUpRequest.getEmailId());
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(signUpRequest.getPassword());
		if(signUpRequest.getRole().equals("ROLE_COMPANY")) {
			Company company = new Company();
			user.setRole(roleRepository.findByRoleName("ROLE_COMPANY"));
			company.setUser(user);
			companyRepository.save(company);
		}
		else {
			UserDetail userDetail = new UserDetail();
			user.setRole(roleRepository.findByRoleName("ROLE_STANDARD"));
			userDetail.setUser(user);
			userDetailRepository.save(userDetail);
		}
		
		userRepository.save(user);
	}

}
