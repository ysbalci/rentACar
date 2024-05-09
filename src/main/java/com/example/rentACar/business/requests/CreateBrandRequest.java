package com.example.rentACar.business.requests;

import lombok.*;

//son kullanıcı tarafından apiye data gönderildiğinde "request" kullanıyoruz
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {

    private String name;
}
