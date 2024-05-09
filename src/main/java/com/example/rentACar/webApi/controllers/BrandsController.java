package com.example.rentACar.webApi.controllers;

import com.example.rentACar.business.abstracs.BrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandResponses;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;


    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    public List<GetAllBrandResponses> getAll(){
        return this.brandService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }


     @GetMapping("/{id}")
     //id değerini path üzerinden alacak
     public GetByIdBrandResponse getById(@PathVariable long id) {
        return this.brandService.getById(id);
     }

     @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
     }

     @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        this.brandService.delete(id);
     }
}
