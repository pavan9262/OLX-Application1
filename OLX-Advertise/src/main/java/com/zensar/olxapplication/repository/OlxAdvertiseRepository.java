package com.zensar.olxapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxapplication.dtos.AdvertiseEntity;

public interface OlxAdvertiseRepository extends JpaRepository<AdvertiseEntity, Long>{

}
