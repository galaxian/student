package com.example.student.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.student.domain.Student;

@Repository
public class StudentRepository {

	private static final Map<Long, Student> store = new HashMap<>();
	private static long sequence = 0L;

	public Student save(Student student) {
		student.addId(++sequence);
		store.put(student.getId(), student);
		return student;
	}

	public List<Student> findAll() {
		return new ArrayList<>(store.values());
	}

	public List<Student> findAllByGrade(int grade) {
		return store.values().stream()
			.filter(student -> student.getGrade() == grade)
			.collect(Collectors.toList());
	}

}
