package com.example.rentACar.webApi.controllers;

import com.example.rentACar.business.abstracs.CarService;
import com.example.rentACar.business.requests.CreateCarRequest;
import com.example.rentACar.business.responses.GetAllCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {
    private CarService carService;

    @GetMapping("/getCars")
    public List<GetAllCarResponse> getAll(){
        return this.carService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);
    }
}
