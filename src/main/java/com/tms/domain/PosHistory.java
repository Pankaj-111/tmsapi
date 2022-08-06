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

@Entity
@Table(name="POS_HISTORY")
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class PosHistory {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="POS_ID")
	private String posId;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="CREATEDATE")
	private LocalDateTime createdDate;
	
	@Column(name="CREATEDBY")
	private Integer createdBy;
	
	@Column(name="MODIDATE")
	private LocalDateTime modifiedDate;	

}
