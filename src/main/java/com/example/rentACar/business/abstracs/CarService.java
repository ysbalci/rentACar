package com.example.rentACar.business.abstracs;

import com.example.rentACar.business.requests.CreateCarRequest;
import com.example.rentACar.business.responses.GetAllCarResponse;
import com.example.rentACar.entities.concretes.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<GetAllCarResponse> getAll();
    void add(CreateCarRequest createCarRequest);
}
