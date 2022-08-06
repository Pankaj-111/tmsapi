package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.domain.PosHistory;

public interface PosHistoryRepository extends JpaRepository<PosHistory, Long>{

}
