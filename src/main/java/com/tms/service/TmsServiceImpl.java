package com.tms.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.domain.Pos;
import com.tms.domain.TmsRequest;
import com.tms.repository.PosRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TmsServiceImpl implements TmsService {

	@Autowired
	PosRepository posRepository;

	@Override
	public void addPosDetails(TmsRequest tmsRequest) {

		try {
			Pos pos = new Pos();
			pos.setIsActive('Y');
			pos.setSerialId(tmsRequest.getDeviceId());
			pos.setModifiedDate(LocalDateTime.now());
			pos.setPosDescritpion("New Pos");
			pos.setCreatedDate(LocalDateTime.now());
			pos.setCreatedBy(111);
			posRepository.save(pos);
		} catch (Exception e) {
			log.error("Failed to add POS details {}",e);
			throw new RuntimeException("Failed to add POS details");
		}
	}

}
