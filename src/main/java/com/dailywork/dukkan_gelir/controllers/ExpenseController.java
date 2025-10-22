package com.dailywork.dukkan_gelir.controllers;

import com.dailywork.dukkan_gelir.CustomUserDetails;
import com.dailywork.dukkan_gelir.dtos.CreateExpenseDto;
import com.dailywork.dukkan_gelir.dtos.ExpenseResponseDto;
import com.dailywork.dukkan_gelir.entities.UserEntity;
import com.dailywork.dukkan_gelir.service.ExpenseService;
import com.dailywork.dukkan_gelir.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController
{
    private final UserService userService;
    private final ExpenseService expenseService;

    @GetMapping("/all")
    public List<ExpenseResponseDto> getAllExpenses(@AuthenticationPrincipal CustomUserDetails  userDetails){
String username = userDetails.getUsername();
        UserEntity user = userService.getUserByUsername(username);

        return expenseService.getAllExpenses(user);
}
    @GetMapping("/{username}")
    public List<ExpenseResponseDto> getUserExpenses(@PathVariable String username,
                                                    @AuthenticationPrincipal CustomUserDetails userDetails){

        return expenseService.getUserExpenses(username);
    }

    @PostMapping("/addExpense")
    public ExpenseResponseDto addExpense(@Valid @RequestBody CreateExpenseDto createExpenseDto, @AuthenticationPrincipal CustomUserDetails  userDetails){

        String username = userDetails.getUsername();
        UserEntity user = userService.getUserByUsername(username);
        return  expenseService.addExpense(createExpenseDto, user);
    }
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable String id, @AuthenticationPrincipal CustomUserDetails  userDetails) {

        String username = userDetails.getUsername();
        UserEntity user = userService.getUserByUsername(username);
        expenseService.deleteExpense(id, user);
    }

}
