package com.zensar.olxapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxapplication.dtos.AdvertiseStatusEntity;

public interface StatusRepository extends JpaRepository<AdvertiseStatusEntity, Long>{

}
