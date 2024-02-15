package com.example.student.dto;

import lombok.Getter;

@Getter
public class StudentResponseDto {

	private String name;
	private int grade;

	public StudentResponseDto(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
}
