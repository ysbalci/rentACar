package com.example.rentACar.webApi.controllers;

import com.example.rentACar.business.abstracs.ModelService;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping("/getModels")
    public List<GetAllModelResponse> getAll(){
        return modelService.getAll();

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
