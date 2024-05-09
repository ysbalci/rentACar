package com.example.rentACar.business.abstracs;

import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandResponses;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    //Burada artık Brand nesnesi yerine response yapısını dönücez. (Son kullanıcya nesneye ait datanın tamamını dönmüyoruz)
    List<GetAllBrandResponses> getAll();
    GetByIdBrandResponse getById(long id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete (long id);

}
