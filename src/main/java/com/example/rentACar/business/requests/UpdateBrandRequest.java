package com.example.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//update işlemlerinde kullanılacak yapı
public class UpdateBrandRequest {
    private long id;
    private String name;
}
