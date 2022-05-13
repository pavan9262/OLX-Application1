package com.zensar.olxapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxapplication.dtos.AdvertiseDetailsEntity;
import com.zensar.olxapplication.dtos.AdvertiseEntity;
import com.zensar.olxapplication.entity.Advertise;
import com.zensar.olxapplication.entity.AdvertiseDetails;
import com.zensar.olxapplication.service.OlxAdvertiseService;

@RestController
//@RequestMapping(value="/advertise", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class AdvertiseController {

	@Autowired

	private OlxAdvertiseService olxAdvertiseService;

	// @PostMapping
	// @ResponseBody
	// Posting new Advertise

	@PostMapping(value = "/advertise", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public AdvertiseEntity addAdvertise(@RequestBody AdvertiseEntity ads, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		return olxAdvertiseService.addAdvertise(ads, username, password);
		// return new ResponseEntity<Advertise>(ads, HttpStatus.CREATED);
	}

	// Update existing Advertise

	// @PutMapping("/advertises/{id}")
	// @GetMapping

	@PutMapping(value = "/advertise/{id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public AdvertiseEntity updateAdvertise(@PathVariable long id, @RequestBody AdvertiseEntity advertise,
			@RequestHeader("userName") String username, @RequestHeader("password") String password) {

		return olxAdvertiseService.updateAdvertise(id, advertise, username, password);
	}

	// getting or read all advertises
	// http://localhost:9090/user/advertise

	// @GetMapping
	@RequestMapping(value = "/user/advertise", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertiseEntity> getAllCategories(@RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		return olxAdvertiseService.getAllCategories(username, password);
	}

	// Getting Specific Advertisement
	// http://localhost:9090/user/advertise/id

	// @GetMapping("/user/advertise/{Id}")
	@RequestMapping(value = "/user/advertise/{Id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public AdvertiseEntity getSpecificAdvertisement(@PathVariable("Id") long id, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		return olxAdvertiseService.getSpecificAdvertisement(id, username, password);
	}

	// Deleting specific Advertise
	// http://localhost:9090/user/advertise/id

	@DeleteMapping("/user/advertise/{Id}")
	public boolean deleteSpecificAdvertise(@PathVariable("Id") long id, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {

		return olxAdvertiseService.deleteSpecificAdvertise(id, username, password);
	}

	// Search advertisements based upon given filter criteria
	// http://localhost:9090/advertise/search/id

	// @GetMapping("advertise/search/filtercriteria")
	@RequestMapping(value = "advertise/search/{Id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public AdvertiseEntity searchfilterCriteria(@PathVariable String category, String toDate, Long filtercriteria, String fromDate) {

		return olxAdvertiseService.searchfilterCriteria(category, toDate, filtercriteria, fromDate);
	}

	// Matches advertisements using the provided 'searchText' within all fields of
	// an advertise.
	// http://localhost:9090/advertise/search

	// @GetMapping("advertise/search")
	@RequestMapping(value = "advertise/search", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertiseEntity> searchText() {

		return olxAdvertiseService.searchText();
	}

	// Getting Specific Advertise Details
	// http://localhost:9090/advertise/id

	// @GetMapping("advertise/{Id}")
	@RequestMapping(value = "/advertise/{postId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<AdvertiseDetailsEntity> getAdvertiseDetails(@PathVariable("postId") long id, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {

		return olxAdvertiseService.getAdvertiseDetails(id, username, password);
	}
}
