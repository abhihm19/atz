package com.osi.atz.service;

import org.springframework.stereotype.Service;

import com.osi.atz.dto.QuestionDto;
import com.osi.atz.model.Challenge;
import com.osi.atz.model.Question;
import com.osi.atz.repository.ChallengeRepository;
import com.osi.atz.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements IQuestionService {
	
	private ChallengeRepository challengeRepository;
	private QuestionRepository questionRepository;	

	public QuestionServiceImpl(ChallengeRepository challengeRepository, QuestionRepository questionRepository) {
		this.challengeRepository = challengeRepository;
		this.questionRepository = questionRepository;
	}

	@Override
	public String createQuestion(QuestionDto questionDto) {
		Challenge challenge = challengeRepository.findById(questionDto.getChallengeId())
				.orElseThrow(() -> new RuntimeException("Challenge not found"));
		Question question = new Question();
		question.setQuestion(questionDto.getQuestion());
		question.setMarks(questionDto.getMarks());
		question.setChallenge(challenge);
		questionRepository.save(question);	
				
	    return "Question created successfully";
	}

	@Override
	public String updateQuestion(QuestionDto questionDto) {	
		Question question = questionRepository.findById(questionDto.getQuestionId())
				.orElseThrow(() -> new RuntimeException("Question not found"));
		question.setQuestion(questionDto.getQuestion());
		question.setMarks(questionDto.getMarks());
		questionRepository.save(question);	
				
	    return "Question updated successfully";
	}

	@Override
	public QuestionDto viewQuestion(int questionId) {
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new RuntimeException("Question not found"));
		QuestionDto questionDto = new QuestionDto();
		questionDto.setQuestion(question.getQuestion());
		questionDto.setMarks(question.getMarks());
		return questionDto;
	}

	@Override
	public String deleteQuestion(int questionId) {
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new RuntimeException("Question not found"));
		questionRepository.delete(question);
	    return "Question deleted successfully";
	}

}
