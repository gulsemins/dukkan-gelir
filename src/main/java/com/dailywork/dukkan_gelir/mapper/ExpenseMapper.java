package com.dailywork.dukkan_gelir.mapper;


import com.dailywork.dukkan_gelir.dtos.CreateExpenseDto;
import com.dailywork.dukkan_gelir.dtos.ExpenseResponseDto;
import com.dailywork.dukkan_gelir.entities.ExpenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {
    //Java da direkt dto yu database e kaydedemiyoruz entity e çevirmemiz gerekiyor.
    // DTO -> Entity
    ExpenseEntity toEntity(CreateExpenseDto createExpenseDto);

    //kullanıcıya direkt entity göstermek iyi değil sadce seçtiğimiz verileri göstermek içim
    // Entity -> ResponseDto
    @Mapping(source = "user.username", target = "username")
    ExpenseResponseDto toExpenseResponseDto(ExpenseEntity expense);


    // EntityList -> ResponseDtoList
    List<ExpenseResponseDto> toExpenseResponseDtoList(List<ExpenseEntity> expenses);
}
