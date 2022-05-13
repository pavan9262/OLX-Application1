package com.zensar.olxapplication.service;

import java.util.List;

import com.zensar.olxapplication.dtos.AdvertiseCategoryEntity;
import com.zensar.olxapplication.dtos.AdvertiseStatusEntity;

public interface AdvertiseService {
	
	List<AdvertiseCategoryEntity> getAllCategories();
	List<AdvertiseStatusEntity> getAllStatus();
}
