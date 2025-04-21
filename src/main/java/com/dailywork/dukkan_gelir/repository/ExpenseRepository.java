package com.dailywork.dukkan_gelir.repository;

import com.dailywork.dukkan_gelir.entities.ExpenseEntity;
import com.dailywork.dukkan_gelir.service.expense.ExpenseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
    List<ExpenseEntity> findByUsername(String username);
}
