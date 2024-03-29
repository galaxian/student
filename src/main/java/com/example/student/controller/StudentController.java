package com.example.student.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.ApiResponse;
import com.example.student.dto.StudentResponseDto;
import com.example.student.exception.InvalidGradeException;
import com.example.student.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@PostMapping("/student")
	public ApiResponse<StudentResponseDto> save(@RequestParam("name") String name, @RequestParam("grade") int grade) {
		StudentResponseDto responseDto = studentService.save(name, grade);
		return makeResponse(responseDto);
	}

	@GetMapping("/student")
	public ApiResponse findAll() {
		List<StudentResponseDto> responseDtoList = studentService.findAll();
		return makeResponse(responseDtoList);
	}

	@GetMapping("/student/{grade}")
	public ApiResponse findAllByGrade(@PathVariable("grade") int grade) {
		List<StudentResponseDto> responseDtoList = studentService.findAllByGrade(grade);
		return makeResponse(responseDtoList);
	}

	private <T> ApiResponse<T> makeResponse(T responseDto) {
		return new ApiResponse<>(responseDto);
	}

	private <T> ApiResponse<T> makeResponse(List<T> responseDto) {
		return new ApiResponse<>(responseDto);
	}

	@ExceptionHandler(InvalidGradeException.class)
	public ApiResponse exceptionHandler(InvalidGradeException invalidGradeException) {
		return new ApiResponse<>(invalidGradeException.getErrorCode().getCode(), invalidGradeException.getMessage(),
			invalidGradeException.getData());
	}
}
