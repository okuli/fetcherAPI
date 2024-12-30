package com.simulated.chunksDataAPI.repository;

import com.simulated.chunksDataAPI.model.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<RecordEntity, Long> {}
