package com.dailywork.dukkan_gelir.controllers;

import com.dailywork.dukkan_gelir.dtos.CreateExpenseDto;
import com.dailywork.dukkan_gelir.dtos.ExpenseResponseDto;
import com.dailywork.dukkan_gelir.entities.ExpenseEntity;
import com.dailywork.dukkan_gelir.repository.ExpenseRepository;
import com.dailywork.dukkan_gelir.service.expense.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController
{
private final ExpenseService expenseService;

    @GetMapping("/all")
    public List<ExpenseResponseDto> getAllExpenses(){

        return expenseService.getAllExpenses();
}
    @GetMapping("/{username}")
    public List<ExpenseResponseDto> getUserExpenses(@PathVariable String username){
        return expenseService.getUserExpenses(username);
    }

    @PostMapping
    public ExpenseResponseDto addExpense(@Valid @RequestBody CreateExpenseDto createExpenseDto){
        return  expenseService.addExpense(createExpenseDto);
    }
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

}
