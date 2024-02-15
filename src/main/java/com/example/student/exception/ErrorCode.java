package com.example.student.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {
	OK(200, "OK", HttpStatus.OK),
	Bad_Request(500, "BAD REQUEST", HttpStatus.BAD_REQUEST);

	private final int code;
	private final String message;
	private final HttpStatus httpStatus;

	ErrorCode(int code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}
}
