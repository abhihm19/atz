package com.osi.atz.service;

import com.osi.atz.dto.QuestionDto;

public interface IQuestionService {
	
	String createQuestion(QuestionDto questionDto);
	String updateQuestion(QuestionDto questionDto);
	QuestionDto	 viewQuestion(int questionId);
	String deleteQuestion(int questionId);

}
