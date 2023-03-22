package com.osi.atz.service;

import java.util.List;

import com.osi.atz.dto.QuestionDto;

public interface IQuestionService {
	
	String createQuestion(QuestionDto questionDto, int challengeId);
	String updateQuestion(QuestionDto questionDto, int questionId);
	QuestionDto	 viewQuestion(int questionId);
	String deleteQuestion(int questionId);
	List<QuestionDto> getQuestions(int challengeId);


}
