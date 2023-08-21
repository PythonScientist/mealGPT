package com.alimama.mealgpt.dao;

import com.alimama.mealgpt.entity.FitnessInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessInfoRepository extends JpaRepository<FitnessInfo, Integer> {
}
