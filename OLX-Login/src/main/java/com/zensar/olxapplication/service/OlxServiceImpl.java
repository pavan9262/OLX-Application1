package com.zensar.olxapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxapplication.dtos.UserDto;
import com.zensar.olxapplication.entity.User;
import com.zensar.olxapplication.repository.OlxLoginRepository;

@Service
public class OlxServiceImpl implements OlxService {

	//static List<UserDto> users = new ArrayList<UserDto>();
	
	@Autowired
	private OlxLoginRepository olxLoginRepository;
	/*static {
		users.add(new User(1L, "Anand", "kulakarni", "anand", "anand123", "anand@gamil.com", 12345));
	}*/

	@Override
	public List<UserDto> getAllUsers(String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			//return users;
			return olxLoginRepository.findAll();
		}

		return null;

	}

	@Override
	public UserDto registerUser(UserDto user) {
		//users.add(user);
		//return user;
		return olxLoginRepository.save(user);
	}

	@Override
	public boolean logoutUser(long id, String username, String password) {

		if (username.equals("anand") && password.equals("anand123")) {
			/*for (User user : users) {
				if (user.getId()==id) {
					users.remove(user);

					return true;
				}

			}*/
			
			olxLoginRepository.deleteById(id);
			return true;

		}
		return false;
	}

	@Override
	public String loginUser(UserDto user) {

		//return user.getUserName() + "\n" + user.getPassword();
		
		return olxLoginRepository.toString();
	}

}