package com.example.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    //mapper için kullanılacak stratejiler tanımlandı
    //------------------------------------------
    //response nesneleri için "model mapper" verecek metot
    ModelMapper forResponse();

    //request nesneleri için "model mapper" verecek metot
    ModelMapper forRequest();
}
