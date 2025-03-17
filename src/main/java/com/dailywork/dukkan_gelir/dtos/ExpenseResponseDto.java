package com.dailywork.dukkan_gelir.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseResponseDto {

    private Integer amount;
    private LocalDate date;

}
