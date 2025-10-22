package com.dailywork.dukkan_gelir.mapper;

import com.dailywork.dukkan_gelir.dtos.CreateIncomeDto;
import com.dailywork.dukkan_gelir.dtos.IncomeResponseDto;
import com.dailywork.dukkan_gelir.entities.IncomeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IncomeMapper {
    IncomeEntity toEntity(CreateIncomeDto createIncomeDto);

    @Mapping(source = "user.username", target = "username")
    IncomeResponseDto toIncomeResponseDto(IncomeEntity entity);

    List<IncomeResponseDto> toIncomeResponseDtoList(List<IncomeEntity> incomes);
}
