package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxapplication.dtos.AdvertiseDetailsEntity;
import com.zensar.olxapplication.dtos.AdvertiseEntity;
import com.zensar.olxapplication.entity.Advertise;
import com.zensar.olxapplication.entity.AdvertiseDetails;
import com.zensar.olxapplication.repository.OlxAdvertiseRepository;

@Service
public class OlxAdvertiseServiceimpl implements OlxAdvertiseService {
	
	@Autowired
	private OlxAdvertiseRepository olxAdvertiseRepository;

	static List<AdvertiseEntity> advertises = new ArrayList<AdvertiseEntity>();
	static List<AdvertiseDetailsEntity> advertiseDetails = new ArrayList<AdvertiseDetailsEntity>();

	static {
		advertises.add(new AdvertiseEntity(1L, "laptop sale", 54000L, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"21-04-2022", "21-04-2022", "OPEN"));
		advertises.add(new AdvertiseEntity(2L, "Sofa available for sale", 30000L, "Furniture",
				"Sofa 5 years Old available for sale in pune", "anand", "22-04-2022", "22-04-2022", "OPEN"));
	}
	
	static {
		advertiseDetails.add(new AdvertiseDetailsEntity(1L, "laptop sale", 54000L, "Electronic goods", "intel core 3 Sony Vaio", "anand",
				"21-04-2022", "21-04-2022", "OPEN", "Anand Kulkarni"));
		advertiseDetails.add(new AdvertiseDetailsEntity(2L, "Sofa available for sale", 30000L, "Furniture",
				"Sofa 5 years Old available for sale in pune", "anand", "22-04-2022", "22-04-2022", "OPEN", "Anand Kulkarni"));
	}

	@Override
	public AdvertiseEntity addAdvertise(AdvertiseEntity ads, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			advertises.add(ads);
			ads.setCategory("Electronic goods");
			ads.setUsername("anand");
			ads.setCreatedDate("21/04/2022");
			ads.setModifiedDate("22/04/22");
			ads.setStatus("OPEN");
			return ads;
		}

		return null;
	}

	@Override
	public AdvertiseEntity updateAdvertise(long id, AdvertiseEntity advertise, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			AdvertiseEntity ads = updateAdvertise(id, advertise, "anand", "anand123");
			ads.setTitle(advertise.getTitle());
			ads.setPrice(advertise.getPrice());
			ads.setDescription(advertise.getDescription());

			return ads;
		}

		return null;
	}

	@Override
	public List<AdvertiseEntity> getAllCategories(String username, String password) {
		if(username.equals("anand")&&password.equals("anand123")) {
			return advertises;
			}
			return null;
	}

	@Override
	public AdvertiseEntity getSpecificAdvertisement(long postId, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {

			for (AdvertiseEntity advertise : advertises) {

				if (advertise.getId() == postId) {
					return advertise;
				}
			}
		}
		return null;
	}

	@Override
	public boolean deleteSpecificAdvertise(long id, String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			for (AdvertiseEntity advertise : advertises) {
				if (advertise.getId() == id) {
					advertises.remove(advertise);

					return true;
				}

			}

		}
		return false;

	}

	@Override
	public AdvertiseEntity searchfilterCriteria(String category, String toDate, Long filtercriteria, String fromDate) {
		for (AdvertiseEntity advertise : advertises) {

			if (advertise.getId() == filtercriteria||advertise.getCategory().equals(category)||advertise.getCreatedDate().equals(fromDate)||advertise.getModifiedDate().equals(toDate)) {
				return advertise;
			}
		}
		return null;
	}

	@Override
	public List<AdvertiseEntity> searchText() {
		return advertises;
	}

	@Override
	public List<AdvertiseDetailsEntity> getAdvertiseDetails(long id, String username, String password) {

		if (username.equals("anand") && password.equals("anand123")) {

			for (AdvertiseDetailsEntity advertise : advertiseDetails) {

				if (advertise.getId() == id) {
					return advertiseDetails;
				}
			}
		}
		return null;
	}

}
