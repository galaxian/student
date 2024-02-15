package com.example.student.dto;

import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

	private Status status;
	private MetaData metaData;
	private List<T> result;

	public ApiResponse(List<T> result) {
		this.status = new Status(2000, "OK");
		this.metaData = new MetaData(result.size());
		this.result = result;
	}

	public ApiResponse(T result) {
		this.status = new Status(2000, "OK");
		this.metaData = new MetaData(1);
		this.result = Collections.singletonList(result);
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
