package com.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.domain.Pos;

@Repository
public interface PosRepository extends JpaRepository<Pos, Integer> {

	public Pos findBySerialId(String posId);
}
