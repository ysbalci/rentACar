package com.example.rentACar.business.concretes;

import com.example.rentACar.business.abstracs.ModelService;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllModelResponse;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.ModelRepository;
import com.example.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = this.modelRepository.findAll();
        List<GetAllModelResponse> modelsResponse = models.stream().map(model ->this.modelMapperService.forResponse().map(model,GetAllModelResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }
}
