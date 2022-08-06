package com.tms.service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.domain.Pos;
import com.tms.domain.PosDetails;
import com.tms.domain.PosHistory;
import com.tms.domain.TmsRequest;
import com.tms.repository.PosDetailsRepository;
import com.tms.repository.PosHistoryRepository;
import com.tms.repository.PosRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TmsServiceImpl implements TmsService {

	private static final String COMMA = ",";
	private PosRepository posRepository;
	private PosDetailsRepository posDetailsRepository;
	private PosHistoryRepository posHistoryRepository;
	
	@Autowired
	public TmsServiceImpl(PosRepository posRepository,PosDetailsRepository posDetailsRepository,PosHistoryRepository posHistoryRepository ) {
		this.posHistoryRepository=posHistoryRepository;
		this.posDetailsRepository= posDetailsRepository;
		this.posRepository= posRepository;
	}
	
	
	@Override
	@Transactional
	public void addPosDetails(TmsRequest tmsRequest) {

		try {
			log.info("Checking if Pos details are already present for POS ID : {}",tmsRequest.getDeviceId());
			// check if POS already exists
			Pos pos = posRepository.findBySerialId(tmsRequest.getDeviceId());
			if (pos == null) {
				insertPos(tmsRequest);
			}
			else {
				log.info("Found pos details for POS ID: {} now an update will be performed ",tmsRequest.getDeviceId());
				updatePosDetails(tmsRequest);
			}
		} catch (Exception e) {
			log.error("Failed to add POS details {}", e);
			throw new RuntimeException("Failed to add POS details");
		}
	}

	private void insertPos(TmsRequest tmsRequest) {
		Pos newPos = new Pos();
		newPos.setIsActive('Y');
		newPos.setSerialId(tmsRequest.getDeviceId());
		newPos.setModifiedDate(LocalDateTime.now());
		newPos.setPosDescritpion("New Pos");
		newPos.setCreatedDate(LocalDateTime.now());
		newPos.setCreatedBy(111);

		PosDetails posDetails = createPosDetailsData(tmsRequest);
		
		PosHistory posHistory = createPosHistoryData(tmsRequest);
		
		log.info("Saving data is POS for POS ID : {}",tmsRequest.getDeviceId());
		posRepository.save(newPos);
		log.info("Saved data succesfully in POS for POS ID : {}",tmsRequest.getDeviceId());
		
		log.info("Saving data is POS_DETAILS for POS ID : {}",tmsRequest.getDeviceId());
		posDetailsRepository.save(posDetails);
		log.info("Saved data succesfully in POS_DETAILS for POS ID : {}",tmsRequest.getDeviceId());
		
		log.info("Saving data is POS_HISTORY for POS ID : {}",tmsRequest.getDeviceId());
		posHistoryRepository.save(posHistory);
		log.info("Saved data succesfully in POS_HISTORY for POS ID : {}",tmsRequest.getDeviceId());
	}
	
	private void updatePosDetails(TmsRequest tmsRequest) {		
		
		
		PosDetails posDetailsFromDb = posDetailsRepository.findByPosId(tmsRequest.getDeviceId());
		
		PosDetails posDetails = createPosDetailsData(tmsRequest);
		//compare if exiting pos details are changed or not. update only if details are updated else skip
		if(!posDetails.equals(posDetailsFromDb)) {
			
			PosHistory posHistory = createPosHistoryData(tmsRequest);
			
			log.info("updating data is POS_DETAILS for POS ID : {}",tmsRequest.getDeviceId());
			posDetailsRepository.deleteById(posDetailsFromDb.getId());
			posDetailsRepository.save(posDetails);
			log.info("Updated data succesfully in POS_DETAILS for POS ID : {}",tmsRequest.getDeviceId());
			
			log.info("Saving data is POS_HISTORY for POS ID : {}",tmsRequest.getDeviceId());
			posHistoryRepository.save(posHistory);
			log.info("Saved data succesfully in POS_HISTORY for POS ID : {}",tmsRequest.getDeviceId());
			
			log.info("updated data successfully for POS ID : {}",tmsRequest.getDeviceId());
		}
		else {
			log.info("Nothing to update for POS ID: {}",tmsRequest.getDeviceId());
		}
		
	}

	private PosDetails createPosDetailsData(TmsRequest tmsRequest) {
		PosDetails posDetails = new PosDetails();
		posDetails.setCreatedBy(111);
		posDetails.setPosId(tmsRequest.getDeviceId());
		posDetails.setIsActive('Y');
		posDetails.setModifiedDate(LocalDateTime.now());
		posDetails.setNwType(tmsRequest.getNwType());
		posDetails.setSignalStrength(tmsRequest.getSignalStrength());
		posDetails.setCreatedDate(LocalDateTime.now());
		posDetails.setLatitude(tmsRequest.getLat());
		posDetails.setLongitude(tmsRequest.getLon());
		posDetails.setAppVerCode(tmsRequest.getAppVerCode());
		posDetails.setAppVerName(tmsRequest.getAppVerName());
		posDetails.setAvailableFreeSpace(tmsRequest.getAvailableFreeSpace());
		posDetails.setBatteryPercentage(tmsRequest.getBatteryPercentage());
		posDetails.setDeviceStartTime(tmsRequest.getDeviceStartTime());
		posDetails.setTimeStampFromDevice(tmsRequest.getTimeStampFromDevice());
		posDetails.setListOfInstalledApps(
				tmsRequest.getListOfInstalledApps().stream().collect(Collectors.joining(COMMA)));
		return posDetails;
	}

	private PosHistory createPosHistoryData(TmsRequest tmsRequest) {
		PosHistory posHistory = new PosHistory();
		posHistory.setCreatedBy(111);
		posHistory.setCreatedDate(LocalDateTime.now());	
		posHistory.setModifiedDate(LocalDateTime.now());
		posHistory.setUserId("111");
		posHistory.setPosId(tmsRequest.getDeviceId());
		return posHistory;
	}

}
