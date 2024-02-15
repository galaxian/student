package com.example.student.domain;

import lombok.Getter;

@Getter
public class Student {

	private Long id;
	private String name;
	private int grade;

	private Student(String name, int grade) {
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
