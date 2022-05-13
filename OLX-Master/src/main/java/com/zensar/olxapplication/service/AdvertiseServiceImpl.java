package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxapplication.dtos.AdvertiseCategoryEntity;
import com.zensar.olxapplication.dtos.AdvertiseStatusEntity;
import com.zensar.olxapplication.entity.AdvertiseCategory;
import com.zensar.olxapplication.entity.AdvertiseStatus;
import com.zensar.olxapplication.repository.CategoryRepository;
import com.zensar.olxapplication.repository.StatusRepository;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<AdvertiseCategoryEntity> getAllCategories() {
		List<AdvertiseCategoryEntity> categories=new ArrayList<AdvertiseCategoryEntity>();
		for(AdvertiseCategoryEntity category : categories) {
			AdvertiseCategoryEntity mapToResponse=modelMapper.map(category,AdvertiseCategoryEntity.class);
			categories.add(mapToResponse);
		}
		return categories;
	}

	@Override
	public List<AdvertiseStatusEntity> getAllStatus() {
		List<AdvertiseStatusEntity> status=new ArrayList<AdvertiseStatusEntity>();
		for(AdvertiseStatusEntity category : status) {
			AdvertiseStatusEntity mapToResponse=modelMapper.map(category,AdvertiseStatusEntity.class);
			status.add(mapToResponse);
		}
		return status;
	}
	
	/*static List<AdvertiseCategory> categories = new ArrayList<AdvertiseCategory>();
	static {
		categories.add(new AdvertiseCategory(1L, "Furniture"));
		categories.add(new AdvertiseCategory(2L, "cars"));
		categories.add(new AdvertiseCategory(3L, "mobiles"));
		categories.add(new AdvertiseCategory(4L, "Real Estate"));
		categories.add(new AdvertiseCategory(5L, "sports"));
	}
	static List<AdvertiseStatus> status = new ArrayList<AdvertiseStatus>();
	static {
		status.add(new AdvertiseStatus(1L, "OPEN"));
		status.add(new AdvertiseStatus(2L, "CLOSE"));
	}*/

	/*@Override
	public List<AdvertiseCategoryEntity> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public List<AdvertiseStatusEntity> getAllStatus() {
		return statusRepository.findAll();
	}*/
	
	

}
