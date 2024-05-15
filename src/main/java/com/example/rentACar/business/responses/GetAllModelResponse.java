package com.example.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelResponse {
    private long id;
    private String name;
    private String brandName;
}
