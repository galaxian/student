package com.example.student.dto;

import com.example.student.domain.Student;

import lombok.Getter;

@Getter
public class StudentResponseDto {

	private String name;
	private int grade;

	public StudentResponseDto(Student student) {
		this.name = student.getName();
		this.grade = student.getGrade();
	}
}
