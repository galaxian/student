package com.example.student.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.ApiResponse;
import com.example.student.dto.StudentResponseDto;
import com.example.student.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@PostMapping("/student")
	public ApiResponse<StudentResponseDto> save(@RequestParam("name") String name, @RequestParam("grade") int grade) {
		StudentResponseDto responseDto = studentService.save(name, grade);
		return new ApiResponse<>(responseDto);
	}
}
