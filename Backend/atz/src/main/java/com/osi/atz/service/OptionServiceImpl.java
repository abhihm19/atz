package com.osi.atz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.osi.atz.dto.OptionDto;
import com.osi.atz.model.Option;
import com.osi.atz.model.Question;
import com.osi.atz.repository.OptionRepository;
import com.osi.atz.repository.QuestionRepository;

@Service
public class OptionServiceImpl implements IOptionService {
	
	private OptionRepository optionRepository;	
	private QuestionRepository questionRepository;
	
	public OptionServiceImpl(OptionRepository optionRepository, QuestionRepository questionRepository) {
		this.optionRepository = optionRepository;
		this.questionRepository = questionRepository;
	}

	@Override
	public String deleteOption(int optionId) {
		Option option = optionRepository.findById(optionId)
				.orElseThrow(() -> new RuntimeException("Option not found"));
		option.setQuestion(null);
		optionRepository.delete(option);
		
		return "Option deleted successfully";
	}

	@Override
	public String createOption(OptionDto optionDto, int questionId) {
		Option option = new Option();
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new RuntimeException("Question not found"));
		option.setOptionDetails(optionDto.getOptionDetails());
		option.setCorrect(optionDto.isCorrect());
		option.setQuestion(question);
		optionRepository.save(option);
		
		return "Option created successfully";
	}

	@Override
	public String updateOption(OptionDto optionDto, int optionId) {		
		Option option = optionRepository.findById(optionId)
				.orElseThrow(() -> new RuntimeException("Option not found"));
		option.setOptionDetails(optionDto.getOptionDetails());
		option.setCorrect(optionDto.isCorrect());
		optionRepository.save(option);
		
		return "Option updated successfully";
	}

	@Override
	public OptionDto viewOption(int optionId) {
		Option option = optionRepository.findById(optionId)
				.orElseThrow(() -> new RuntimeException("Option not found"));
		return mapToOptionDto(option);
	}

	private OptionDto mapToOptionDto(Option option) {
		OptionDto optionDto = new OptionDto();
		optionDto.setOptionDetails(option.getOptionDetails());
		optionDto.setCorrect(option.isCorrect());
		return optionDto;
	}

	@Override
	public List<OptionDto> getOptions(int questionId) {
		List<Option> options = optionRepository.findAll();
		return options.stream().map((option) -> mapToOptionDto(option)).collect(Collectors.toList());
	}

}
