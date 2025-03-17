package com.dailywork.dukkan_gelir.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateExpenseDto {
    //private String username;
    private  Integer amount;
   // private LocalDate date;
}
