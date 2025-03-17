package com.dailywork.dukkan_gelir.controllers;

import com.dailywork.dukkan_gelir.dtos.CreateExpenseDto;
import com.dailywork.dukkan_gelir.dtos.ExpenseResponseDto;
import com.dailywork.dukkan_gelir.entities.ExpenseEntity;
import com.dailywork.dukkan_gelir.repository.ExpenseRepository;
import com.dailywork.dukkan_gelir.service.expense.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController
{
private final ExpenseService expenseService;

    @GetMapping
    List<ExpenseResponseDto> getAllExpenses(){
        return expenseService.getAllExpenses();
}
    @PostMapping
    public ExpenseResponseDto addExpense(@RequestBody CreateExpenseDto createExpenseDto){
        return  expenseService.addExpense(createExpenseDto);
    }

}
