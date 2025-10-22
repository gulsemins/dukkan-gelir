package com.dailywork.dukkan_gelir.service;

import com.dailywork.dukkan_gelir.dtos.CreateIncomeDto;
import com.dailywork.dukkan_gelir.dtos.IncomeResponseDto;
import com.dailywork.dukkan_gelir.entities.IncomeEntity;
import com.dailywork.dukkan_gelir.entities.UserEntity;
import com.dailywork.dukkan_gelir.mapper.IncomeMapper;
import com.dailywork.dukkan_gelir.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final IncomeMapper incomeMapper;

    public IncomeResponseDto addIncome(CreateIncomeDto createIncomeDto, UserEntity user){
        IncomeEntity income = incomeMapper.toEntity(createIncomeDto);
        income.setUser(user);
        IncomeEntity savedIncome = incomeRepository.save(income);
        return incomeMapper.toIncomeResponseDto(savedIncome);
    }

    public List<IncomeResponseDto> getAllIncomes(UserEntity user) {
        List<IncomeEntity> allIncomes = incomeRepository.findByUser_Username(user.getUsername());
        return incomeMapper.toIncomeResponseDtoList(allIncomes);
    }

    public List<IncomeResponseDto> getUserIncomes(String username) {
        List<IncomeEntity> incomes = incomeRepository.findByUser_Username(username);
        return incomeMapper.toIncomeResponseDtoList(incomes);
    }

    public void deleteIncome(String id, UserEntity user) {
        IncomeEntity income = incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income not found"));

        if (!income.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("You are not allowed to delete this income");
        }

        incomeRepository.delete(income);
    }
}