package com.example.student.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class InvalidGradeException extends RuntimeException{

	private ErrorCode errorCode;
	private String message;
	private InputRestriction data;

	public InvalidGradeException(ErrorCode errorCode, String message, int data) {
		this.errorCode = errorCode;
		this.message = message;
		this.data = new InputRestriction(data);
	}

	@Getter
	@AllArgsConstructor
	private static class InputRestriction {
		private int maxGrade;
	}
}
