package com.osi.atz.service;

import com.osi.atz.model.Option;

public interface IOptionService {
	
	String createOption(Option option);
	String updateOption(Option option);
	Option viewOption(int optionId);
	String deleteOption(int optionId);

}
