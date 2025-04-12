package com.dailywork.dukkan_gelir.controllers;

import com.dailywork.dukkan_gelir.dtos.CreateIncomeDto;
import com.dailywork.dukkan_gelir.dtos.IncomeResponseDto;
import com.dailywork.dukkan_gelir.service.expense.IncomeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/incomes")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping
    List<IncomeResponseDto> getAllIncomes() {
        return incomeService.getAllIncomes();
    }
    @PostMapping
    public IncomeResponseDto addIncome(@Valid @RequestBody CreateIncomeDto createIncomeDto){
        return incomeService.addIncome(createIncomeDto);

    }
    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id){
        incomeService.deleteIncome(id);
    }
}
