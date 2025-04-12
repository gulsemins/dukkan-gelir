package com.dailywork.dukkan_gelir.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeResponseDto {
    private Long id;
    private Integer amount;
    private LocalDate date;


}
