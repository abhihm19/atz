package com.osi.atz.service;

import java.util.List;

import com.osi.atz.dto.OptionDto;

public interface IOptionService {
	
	String createOption(OptionDto optionDto, int questionId);
	String updateOption(OptionDto optionDto, int optionId);
	OptionDto viewOption(int optionId);
	String deleteOption(int optionId);
	List<OptionDto> getOptions(int questionId);

}
