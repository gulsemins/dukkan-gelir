package com.dailywork.dukkan_gelir.controllers;

import com.dailywork.dukkan_gelir.dtos.CreateIncomeDto;
import com.dailywork.dukkan_gelir.dtos.IncomeResponseDto;
import com.dailywork.dukkan_gelir.service.expense.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomes")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping
    List<IncomeResponseDto> getAllIncomes() {
        return incomeService.getAllIncomes();
    }
    @PostMapping
    public IncomeResponseDto addIncome(@RequestBody CreateIncomeDto createIncomeDto){
        return incomeService.addIncome(createIncomeDto);
    }
}
