package com.example.rentACar.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//ıd değerine göre tek bir marka listelemek için kullanılacak yapı
public class GetByIdBrandResponse {
    private long id;
    private String name;
}
