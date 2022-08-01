package com.tms.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TmsRequest {
	
	private String deviceId;
	private String appVerName;
	private String appVerCode;
	private String lat;
	private String lon;
	private String timeStampFromDevice;
	private Long batteryPercentage;
	private String signalStrength;
	private String nwType;
	private Long deviceStartTime;
	private String availableFreeSpace;
	private List<String> listOfInstalledApps;

}


