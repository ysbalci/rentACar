package com.example.rentACar.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{
    //hangi alanda hangi hatanın olduğunu görmek için hashmap kullanıyoruz
    private Map<String ,String> validationException;
}
