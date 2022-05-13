package com.zensar.olxapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxapplication.dtos.AdvertiseDetailsEntity;

public interface OlxAdvertiseDetailsRepository extends JpaRepository<AdvertiseDetailsEntity, Long>{

}
