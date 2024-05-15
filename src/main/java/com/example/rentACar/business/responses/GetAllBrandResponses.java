package com.example.rentACar.business.responses;

import lombok.*;

//son kullanıcıya data döndüreceksek "response" kullanıyoruz
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandResponses {
//api de geriye döndüreceğimiz dataları tanımlıyoruz
    private long id;
    private String name;

}
