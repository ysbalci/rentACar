package com.example.rentACar.business.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    @NotNull
    @NotBlank
    private String plate;

    @NotNull
    private double dailyPrice;

    @NotNull
    private int modelYear;

    @NotNull
    private long modelId;
}
