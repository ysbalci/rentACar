package com.example.rentACar.business.concretes;

import com.example.rentACar.business.abstracs.CarService;
import com.example.rentACar.business.requests.CreateCarRequest;
import com.example.rentACar.business.responses.GetAllCarResponse;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.CarRepository;
import com.example.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car> cars = this.carRepository.findAll();
        List<GetAllCarResponse> carResponses = cars.stream().map(car ->this.modelMapperService.forResponse().map(car, GetAllCarResponse.class)).toList();
        return carResponses;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        this.carRepository.save(car);
    }
}
