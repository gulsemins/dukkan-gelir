package com.dailywork.dukkan_gelir.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeResponseDto {
    private String id;
    private String username;
    private Integer amount;
    private Date createdAt;


}
