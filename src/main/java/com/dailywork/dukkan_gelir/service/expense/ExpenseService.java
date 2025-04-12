package com.dailywork.dukkan_gelir.service.expense;

import com.dailywork.dukkan_gelir.dtos.CreateExpenseDto;
import com.dailywork.dukkan_gelir.dtos.ExpenseResponseDto;
import com.dailywork.dukkan_gelir.entities.ExpenseEntity;
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
    public ExpenseResponseDto addExpense(CreateExpenseDto createExpenseDto){
        // ExpenseEntity expense = new ExpenseEntity();
        // expense.setAmount(createExpenseDto.getAmount());
        //ilk adım database kaydetmek ama database entitiy olarak kaydettiğimiz için create response u entitiye çeviriyoruz
        // DTO -> Entity
        ExpenseEntity expense = expenseMapper.toEntity(createExpenseDto);
        // Save Enity
        ExpenseEntity savedExpense = expenseRepository.save(expense);
        //Java da direkt dto yu database e kaydedemiyoruz entity e çevirmemiz gerekiyor.

        return expenseMapper.toExpenseResponseDto(savedExpense);

    }
    public List<ExpenseResponseDto> getAllExpenses(){
        List<ExpenseEntity> allExpenses = expenseRepository.findAll();

        return expenseMapper.toExpenseResponseDtoList(allExpenses);

    }
    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }
}