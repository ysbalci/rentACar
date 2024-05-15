package com.example.rentACar.dataAccess.abstracts;


import com.example.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    boolean existsByName(String name);
    //name alanına göre true-false döndürecek
}
