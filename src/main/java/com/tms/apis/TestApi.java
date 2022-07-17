package com.tms.apis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Student resources that provides access to availabe student data", name = "Student Resource")
@RestController
public class TestApi {

	@Operation(summary = "Get students", description = "Provides all available students list")
	@GetMapping("/test")
	public String test() {
		return "Test Successfull";
	}
}
