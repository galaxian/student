package com.example.student.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
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

	private ApiResponse<StudentResponseDto> makeResponse(StudentResponseDto responseDto) {
		return new ApiResponse<>(responseDto);
	}

	@ExceptionHandler(InvalidGradeException.class)
	public ApiResponse exceptionHandler(InvalidGradeException invalidGradeException) {
		return new ApiResponse<>(invalidGradeException.getErrorCode().getCode(), invalidGradeException.getMessage(),
			invalidGradeException.getData());
	}
}
