package com.zensar.olxapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.dtos.AdvertiseCategoryEntity;
import com.zensar.olxapplication.dtos.AdvertiseStatusEntity;
import com.zensar.olxapplication.entity.AdvertiseCategory;
import com.zensar.olxapplication.entity.AdvertiseStatus;
import com.zensar.olxapplication.service.AdvertiseService;

@RestController
//@RequestMapping(value="/advertise", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class AdvertiseController {

	@Autowired
	private AdvertiseService advertiseService;

	// Returns all advertisement categories
	// @GetMapping
	@RequestMapping(value = "/advertise/category", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertiseCategoryEntity> getAllCategories() {
		return advertiseService.getAllCategories();
	}

	// Returns all advertisement status

	// @GetMapping
	@RequestMapping(value = "advertise/status", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertiseStatusEntity> getAllStatus() {
		return advertiseService.getAllStatus();
	}

}
