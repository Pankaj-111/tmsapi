package com.tms.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tms.domain.TmsRequest;
import com.tms.domain.TmsResponse;
import com.tms.service.TmsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TmsController {
	
	@Autowired
	TmsService tmsService;
	
	@PostMapping("/addDevice")
	public TmsResponse getData(@RequestBody TmsRequest tmsRequest) {
		log.info("Received request : {}",tmsRequest);
		tmsService.addPosDetails(tmsRequest);		
		TmsResponse response = new TmsResponse(LocalDateTime.now(), "Succesfully added POS details.");
		return response;
	}
}
