package com.dailywork.dukkan_gelir.repository;

import com.dailywork.dukkan_gelir.entities.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<IncomeEntity, String> {
    List<IncomeEntity> findByUser_Username(String username);}
