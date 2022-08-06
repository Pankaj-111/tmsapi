package com.tms.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "POS_DETAILS")
@EqualsAndHashCode(exclude={"id","createdDate","modifiedDate"})
public class PosDetails {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="POS_ID")
	private String posId;
	
	@Column(name="LATITUDE")
	private String latitude;
	
	@Column(name="LONGITUDE") 	
	private String longitude;	
	
	@Column(name="CREATEDATE")
	private LocalDateTime createdDate;
	
	@Column(name="CREATEDBY")
	private Integer createdBy;
	
	@Column(name="MODIDATE")
	private LocalDateTime modifiedDate;
	
	@Column(name="ISACTIVE")
	private char isActive;
	
	@Column(name="BATTERY_PERCENTAGE")
	private Long batteryPercentage;
	
	@Column(name="APP_VER_NAME")
	private String appVerName;
	
	@Column(name="APP_VER_CODE")
	private String appVerCode;	
	
	@Column(name="TIME_STAMP_FROM_DEVICE")
	private String timeStampFromDevice;
	
	@Column(name="SIGNAL_STRENGTH")
	private String signalStrength;
	
	@Column(name="NETWORK_TYPE")
	private String nwType;
	
	@Column(name="DEVICE_START_TIME")
	private Long deviceStartTime;
	
	@Column(name="AVAILABLE_FREE_SPACE")
	private String availableFreeSpace;
	
	@Column(name="INSTALLED_APPS")
	private String listOfInstalledApps;

}
