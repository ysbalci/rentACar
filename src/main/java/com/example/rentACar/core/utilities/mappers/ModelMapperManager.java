package com.example.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{
    //ihtiyacımız olan modal mapper enjeksiyon edilir ve main classıda @Bean anotasyonu uygulanır
    private ModelMapper modelMapper;
    @Override
    // mapping işlemini gevşek biçimde yapacak olan strateji
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    @Override
    // mapping işlemini sıkı biçimde yapacak olan strateji
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
