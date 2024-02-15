package com.example.student.service;

import java.util.List;
import java.util.stream.Collectors;

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
		return new StudentResponseDto(saveStudent);
	}

	public List<StudentResponseDto> findAll() {
		List<Student> studentList = studentRepository.findAll();
		return studentList.stream()
			.map(StudentResponseDto::new)
			.collect(Collectors.toList());
	}

	public List<StudentResponseDto> findAllByGrade(int grade) {
		List<Student> studentList = studentRepository.findAllByGrade(grade);
		return studentList.stream()
			.map(StudentResponseDto::new)
			.collect(Collectors.toList());
	}
}
