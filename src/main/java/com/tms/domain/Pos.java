package com.tms.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pos {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="SERIAL_ID")
	private String serialId;
	
	@Column(name="POS_DESCRIPTION")
	private String posDescritpion;
	
	@Column(name="CREATEDATE")
	private LocalDateTime createdDate;
	
	@Column(name="CREATEDBY")
	private Integer createdBy;
	
	@Column(name="MODIDATE")
	private LocalDateTime modifiedDate;
	
	@Column(name="ISACTIVE")
	private char isActive;
}
