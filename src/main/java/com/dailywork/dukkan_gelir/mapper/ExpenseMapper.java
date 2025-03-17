package com.dailywork.dukkan_gelir.mapper;


import com.dailywork.dukkan_gelir.dtos.CreateExpenseDto;
import com.dailywork.dukkan_gelir.dtos.ExpenseResponseDto;
import com.dailywork.dukkan_gelir.entities.ExpenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseMapper {
    //Java da direkt dto yu database e kaydedemiyoruz entity e çevirmemiz gerekiyor.

    ExpenseResponseDto toResponseDto(ExpenseEntity expenseEntity);

    ExpenseEntity toEntity(CreateExpenseDto createExpenseDto);
}
