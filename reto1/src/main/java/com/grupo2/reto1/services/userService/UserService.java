package com.grupo2.reto1.services.userService;


import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;

import com.grupo2.reto1.modelos.songModelo.SongGetResponse;
import com.grupo2.reto1.modelos.userModelo.UserGetResponse;
import com.grupo2.reto1.modelos.userModelo.UserPostRequest;

public interface UserService {
	
	UserGetResponse getUserById(Long id);
	int createUser(UserPostRequest postRequest);
	int updateUser(Long id,UserPostRequest postRequest);
	int deleteUserById(Long id);
	
	
}
