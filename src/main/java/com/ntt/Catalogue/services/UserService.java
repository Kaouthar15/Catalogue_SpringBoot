package com.ntt.Catalogue.services;

import java.util.List;

import com.ntt.Catalogue.models.User;
import com.ntt.Catalogue.models.UserDto;

public interface UserService {
	 void saveUser(UserDto userDto);
	 User findUserByEmail(String email);
	 List<UserDto> findAllUsers();
}