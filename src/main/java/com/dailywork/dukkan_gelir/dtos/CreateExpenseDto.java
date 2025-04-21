package com.dailywork.dukkan_gelir.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDate;

@Data
public class CreateExpenseDto {
    //private String username;
    @NotNull(message = "Kullanıcı adı boş olamaz!")
    private String username;
    private String category;
    @NotNull(message = "Amount cannot be null")
    @Min(value = 1, message = "Amount must be at least 1")
    private  Integer amount;
    @NotNull
    private LocalDate date;
}
