package com.dailywork.dukkan_gelir.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class IncomeResponseDto {
    private Integer amount;
    private LocalDate date;
}
