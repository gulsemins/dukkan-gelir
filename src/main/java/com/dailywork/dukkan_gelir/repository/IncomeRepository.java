package com.dailywork.dukkan_gelir.repository;

import com.dailywork.dukkan_gelir.entities.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Long> {
}
