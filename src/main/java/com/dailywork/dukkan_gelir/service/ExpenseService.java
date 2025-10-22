package com.dailywork.dukkan_gelir.service;

import com.dailywork.dukkan_gelir.dtos.CreateExpenseDto;
import com.dailywork.dukkan_gelir.dtos.ExpenseResponseDto;
import com.dailywork.dukkan_gelir.entities.ExpenseEntity;
import com.dailywork.dukkan_gelir.entities.UserEntity;
import com.dailywork.dukkan_gelir.mapper.ExpenseMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dailywork.dukkan_gelir.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService  {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

//burda kullanıcıya döndüreceğimiz şey expenseResponseDto bu fonksiyon dönüreceğimizin tipii olmalı yani expenseresponsedto
    public ExpenseResponseDto addExpense(CreateExpenseDto createExpenseDto, UserEntity user){
        // ExpenseEntity expense = new ExpenseEntity();
        // expense.setAmount(createExpenseDto.getAmount());
        //ilk adım database kaydetmek ama database entitiy olarak kaydettiğimiz için create response u entitiye çeviriyoruz
        // DTO -> Entity
        ExpenseEntity expense = expenseMapper.toEntity(createExpenseDto);
        expense.setUser(user);
        // Save Enity
        ExpenseEntity savedExpense = expenseRepository.save(expense);
        //Java da direkt dto yu database e kaydedemiyoruz entity e çevirmemiz gerekiyor.

        return expenseMapper.toExpenseResponseDto(savedExpense);

    }
    public List<ExpenseResponseDto> getAllExpenses(UserEntity user){
        List<ExpenseEntity> allExpenses = expenseRepository.findByUser_Username(user.getUsername());
        return expenseMapper.toExpenseResponseDtoList(allExpenses);
    }
    public List<ExpenseResponseDto> getUserExpenses(String username) {
        List<ExpenseEntity> expenses = expenseRepository.findByUser_Username(username);        return expenseMapper.toExpenseResponseDtoList(expenses);
    }


    public void deleteExpense(String id, UserEntity user) {
        ExpenseEntity expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        // 🔸 Güvenlik kontrolü: sadece kendi harcamasını silebilir
        if (!expense.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You are not allowed to delete this expense");
        }

        expenseRepository.delete(expense);
    }
}