package com.dailywork.dukkan_gelir.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ExpenseResponseDto {
    private String id;
    private String username;
    private String category;
    private Integer amount;
    private Date createdAt;

}
