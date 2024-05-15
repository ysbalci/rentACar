package com.example.rentACar.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//hata alındığında sistemle ilgili bilgi göndermek yerine bu yapıyı döndürücez
public class ProblemDetails {
    String message;
}
