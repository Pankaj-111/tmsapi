package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.domain.PosDetails;

public interface PosDetailsRepository extends JpaRepository<PosDetails, Long> {
	
	public PosDetails findByPosId(String posId);
}
