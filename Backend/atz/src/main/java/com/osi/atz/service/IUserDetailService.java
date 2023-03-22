package com.osi.atz.service;

import com.osi.atz.dto.UserDetailDto;

public interface IUserDetailService {

	String updateUserDetail(UserDetailDto userDto, int userDetailId);
	UserDetailDto	viewUserDetail(int userDetailId);
	String deleteUserDetail(int userDetailId);
}
