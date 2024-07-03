package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

	private String message;
	private LocalDate timestamp;
	
	
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timestamp = timestamp.now();
	}
	
	
	
}
