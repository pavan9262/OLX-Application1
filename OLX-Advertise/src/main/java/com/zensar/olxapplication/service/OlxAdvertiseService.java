package com.zensar.olxapplication.service;

import java.util.List;

import com.zensar.olxapplication.dtos.AdvertiseDetailsEntity;
import com.zensar.olxapplication.dtos.AdvertiseEntity;

public interface OlxAdvertiseService {

	AdvertiseEntity addAdvertise(AdvertiseEntity ads, String username, String password);

	AdvertiseEntity updateAdvertise(long id, AdvertiseEntity advertise, String username, String password);

	List<AdvertiseEntity> getAllCategories(String username, String password);

	AdvertiseEntity getSpecificAdvertisement(long id, String username, String password);

	boolean deleteSpecificAdvertise(long id, String username, String password);

	AdvertiseEntity searchfilterCriteria(String category, String toDate, Long filtercriteria, String fromDate);

	List<AdvertiseEntity> searchText();

	List<AdvertiseDetailsEntity> getAdvertiseDetails(long id, String username, String password);

}
