package com.dailywork.dukkan_gelir.controllers;

import com.dailywork.dukkan_gelir.CustomUserDetails;
import com.dailywork.dukkan_gelir.dtos.CreateIncomeDto;
import com.dailywork.dukkan_gelir.dtos.IncomeResponseDto;
import com.dailywork.dukkan_gelir.entities.UserEntity;
import com.dailywork.dukkan_gelir.service.IncomeService;
import com.dailywork.dukkan_gelir.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/incomes")
@RequiredArgsConstructor
public class IncomeController {


    private final IncomeService incomeService;
    private final UserService userService;

    @GetMapping("/all")
    public List<IncomeResponseDto> getAllIncomes(@AuthenticationPrincipal CustomUserDetails userDetails) {
        String username = userDetails.getUsername();
        UserEntity user = userService.getUserByUsername(username);
        return incomeService.getAllIncomes(user);
    }

    @GetMapping("/{username}")
    public List<IncomeResponseDto> getUserIncomes(@PathVariable String username) {
        return incomeService.getUserIncomes(username);
    }

    @PostMapping
    public IncomeResponseDto addIncome(
            @Valid @RequestBody CreateIncomeDto createIncomeDto,
            @AuthenticationPrincipal CustomUserDetails userDetails) {

        String username = userDetails.getUsername();
        UserEntity user = userService.getUserByUsername(username);
        return incomeService.addIncome(createIncomeDto, user);
    }
    @DeleteMapping("/{id}")
    public void deleteIncome(
            @PathVariable String id,
            @AuthenticationPrincipal CustomUserDetails userDetails) {

        String username = userDetails.getUsername();
        UserEntity user = userService.getUserByUsername(username);
        incomeService.deleteIncome(id, user);
    }}
