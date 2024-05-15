package com.example.rentACar.business.concretes;

import com.example.rentACar.business.abstracs.BrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandResponses;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.business.rules.BrandBusinessRules;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    //brand nesnesi ile response-request nesnelerini map etmek için model mapper enjekte edildi.
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllBrandResponses> getAll() {
        List<Brand> brands = this.brandRepository.findAll();

        //brands.stream() işlemi brands listesini tek tek gezer (forEach gibi)
        //map(brand->"Response") işlemi her brand için mapping işlemini yapar
        List<GetAllBrandResponses> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandResponses.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        //iş kuralı eğer aynı isimde brand var ise exception fırlatacak
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        // Request nesnesini Brand nesnesine çevirdik
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }
    @Override
    public GetByIdBrandResponse getById(long id) {
        //finById optional döndüğü için orElseThrow kullanılır
        Brand brand = this.brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(long id) {
        this.brandRepository.deleteById(id);
    }


}
