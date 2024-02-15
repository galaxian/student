package com.example.student.repository;

import java.util.HashMap;
import java.util.Map;

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

}
