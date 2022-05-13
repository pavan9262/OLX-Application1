package com.zensar.olxapplication.service;

import java.util.List;

import com.zensar.olxapplication.dtos.UserDto;

public interface OlxService {

	List<UserDto> getAllUsers(String username, String password);

	UserDto registerUser(UserDto user);

	boolean logoutUser(long id, String username, String password);

	String loginUser(UserDto user);
}