package com.example.foodmarket.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategoryDTO {
    @NotEmpty(message = "Name required")
    private String name;
}
