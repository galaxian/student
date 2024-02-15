package com.example.student.dto;

import static com.example.student.exception.ErrorCode.*;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

	private Status status;
	@JsonInclude(NON_EMPTY)
	private MetaData metaData;
	@JsonInclude(NON_EMPTY)
	private List<T> result;
	@JsonInclude(NON_EMPTY)
	private Object data;

	public ApiResponse(List<T> result) {
		this.status = new Status(OK.getCode(), OK.getMessage());
		this.metaData = new MetaData(result.size());
		this.result = result;
	}

	public ApiResponse(T result) {
		this.status = new Status(OK.getCode(), "OK");
		this.metaData = new MetaData(1);
		this.result = Collections.singletonList(result);
	}

	public ApiResponse(int code, String message, Object data) {
		this.status = new Status(code, message);
		this.data = data;
	}

	@Getter
	@AllArgsConstructor
	private static class Status {
		private int code;
		private String message;
	}

	@Getter
	@AllArgsConstructor
	private static class MetaData {
		private int resultCount;
	}
}
