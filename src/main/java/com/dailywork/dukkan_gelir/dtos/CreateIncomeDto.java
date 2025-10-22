package com.dailywork.dukkan_gelir.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateIncomeDto {
    @NotNull(message = "Amount cannot be null")
    @Min(value = 1, message = "Amount must be at least 1")
    private Integer amount;


}
