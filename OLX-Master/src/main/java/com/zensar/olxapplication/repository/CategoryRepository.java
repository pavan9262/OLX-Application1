package com.zensar.olxapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxapplication.dtos.AdvertiseCategoryEntity;

public interface CategoryRepository extends JpaRepository<AdvertiseCategoryEntity, Long>{

}
