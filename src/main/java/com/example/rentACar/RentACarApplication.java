package com.example.rentACar;

import com.example.rentACar.core.utilities.exceptions.BusinessException;
import com.example.rentACar.core.utilities.exceptions.ProblemDetails;
import com.example.rentACar.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
//bütün controllerlar burdaki exceptionhandler'atabi tutuldu
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	//uygulama başlatıldığında IoC de kullanılacak gerekli model mapper için

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	//Hangi hata durumunun ele alıncağı parametre olarak verilir
	public ProblemDetails handleBusinessException(BusinessException businessException){
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	//Hangi hata durumunun ele alıncağı parametre olarak verilir
	public ProblemDetails handleBusinessException(MethodArgumentNotValidException methodArgumentNotValidException){
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation Exception");
		validationProblemDetails.setValidationException(new HashMap<String,String>());
		for (FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()) {

			validationProblemDetails.getValidationException().put(fieldError.getField(),fieldError.getDefaultMessage());
		}

		return validationProblemDetails;
	}



	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
