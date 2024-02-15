package com.example.student.domain;

import static com.example.student.exception.ErrorCode.*;

import com.example.student.exception.InvalidGradeException;

import lombok.Getter;

@Getter
public class Student {

	private final static int MAX_GRADE = 6;

	private Long id;
	private String name;
	private int grade;

	private Student(String name, int grade) {
		if (grade >= MAX_GRADE) {
			throw new InvalidGradeException(Bad_Request, "grade는 6이상 입력할 수 없습니다.", MAX_GRADE);
		}
		this.name = name;
		this.grade = grade;
	}

	public static Student of(String name, int grade) {
		return new Student(name, grade);
	}

	public void addId(Long id) {
		this.id = id;
	}
}
