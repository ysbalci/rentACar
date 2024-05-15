package com.example.rentACar.business.responses;

import com.example.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponse {
    private double dailyPrice;
    private int modelYear;
    private String modelName;
}
