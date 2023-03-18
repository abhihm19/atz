package com.osi.atz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.atz.dto.ApiResponse;
import com.osi.atz.dto.QuestionDto;
import com.osi.atz.service.IQuestionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api/v1/company/challenge/{id}/question")
public class QuestionController {
	
	private IQuestionService questionService;

	public QuestionController(IQuestionService questionService) {
		this.questionService = questionService;
	}
	
	@PostMapping()
    public ResponseEntity<ApiResponse> createQuestion(@RequestBody QuestionDto questionDto) {
		String output = questionService.createQuestion(questionDto);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	
	@PutMapping()
    public ResponseEntity<ApiResponse> updateQuestion(@RequestBody QuestionDto questionDto) {
		String output = questionService.updateQuestion(questionDto);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	
	@GetMapping("/{questionId}")
    public ResponseEntity<QuestionDto> viewQuestion(@PathVariable int questionId) {
		QuestionDto questionDto = questionService.viewQuestion(questionId);
    	return ResponseEntity.ok().body(questionDto);	
	}
	
	@DeleteMapping("/{questionId}")
    public ResponseEntity<ApiResponse> deleteQuestion(@PathVariable int questionId) {
		String output = questionService.deleteQuestion(questionId);
    	return ResponseEntity.ok().body(new ApiResponse(true,output));	
	}
	
	
	

}
