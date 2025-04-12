package com.dailywork.dukkan_gelir.service.expense;

import com.dailywork.dukkan_gelir.dtos.CreateIncomeDto;
import com.dailywork.dukkan_gelir.dtos.IncomeResponseDto;
import com.dailywork.dukkan_gelir.entities.IncomeEntity;
import com.dailywork.dukkan_gelir.mapper.IncomeMapper;
import com.dailywork.dukkan_gelir.repository.IncomeRepository;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class IncomeService {
    private final IncomeRepository incomeRepository;
    private final IncomeMapper incomeMapper;

    public IncomeResponseDto addIncome(CreateIncomeDto createIncomeDto){
      IncomeEntity income = incomeMapper.toEntity(createIncomeDto);
      IncomeEntity savedIncome = incomeRepository.save(income);

      return incomeMapper.toIncomeResponseDto(savedIncome);

    }

    public List<IncomeResponseDto> getAllIncomes( ){
        List<IncomeEntity> allIncomes = incomeRepository.findAll();
        return incomeMapper.toIncomeResponseDtoList(allIncomes);
    }

    public void deleteIncome(Long id){
        incomeRepository.deleteById(id);
    }
}
