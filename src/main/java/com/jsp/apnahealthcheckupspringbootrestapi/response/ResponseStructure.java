package com.jsp.apnahealthcheckupspringbootrestapi.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseStructure<T> {

	private int statusCode;
	private String statusMessage;
	private T statusData;
}
