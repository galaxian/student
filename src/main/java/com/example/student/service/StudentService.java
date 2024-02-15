package com.example.student.service;

import org.springframework.stereotype.Service;

import com.example.student.domain.Student;
import com.example.student.dto.StudentResponseDto;
import com.example.student.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentResponseDto save(String name, int grade) {
		Student student = Student.of(name, grade);
		Student saveStudent = studentRepository.save(student);
		return new StudentResponseDto(saveStudent.getName(), saveStudent.getGrade());
	}
}
