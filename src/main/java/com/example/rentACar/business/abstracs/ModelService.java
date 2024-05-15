package com.example.rentACar.business.abstracs;

import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
