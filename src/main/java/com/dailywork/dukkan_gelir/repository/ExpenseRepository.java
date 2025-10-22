package com.dailywork.dukkan_gelir.repository;

import com.dailywork.dukkan_gelir.entities.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, String> {
    List<ExpenseEntity> findByUser_Username(String username);
}
