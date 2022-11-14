package com.grupo2.reto1.services.userService;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.grupo2.reto1.modelos.favoriteModelo.Favorite;
import com.grupo2.reto1.modelos.favoriteModelo.FavoriteGetResponse;
import com.grupo2.reto1.modelos.songModelo.Song;
import com.grupo2.reto1.modelos.songModelo.SongGetResponse;
import com.grupo2.reto1.modelos.userModelo.User;
import com.grupo2.reto1.modelos.userModelo.UserGetResponse;
import com.grupo2.reto1.modelos.userModelo.UserPostRequest;
import com.grupo2.reto1.repositories.songRepository.SongRepository;
import com.grupo2.reto1.repositories.userRepository.UserRepository;
import com.grupo2.reto1.services.favoriteService.FavoriteService;
import com.grupo2.reto1.services.songService.SongService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	FavoriteService favoriteService;
	@Autowired
	SongService songService;
	@Autowired 
	AuthenticationManager authManager;

	@Override
	public UserGetResponse getUserById(Long id) {

		User user = userRepository.getUserById(id);
		UserGetResponse userGetResponse = new UserGetResponse(user.getId(), user.getLoginUser(), user.getNombre(),
				user.getApellidos(), user.getEmail(), null);

		return userGetResponse;
	}

	@Override
	public int createUser(UserPostRequest userPostRequest) {

		User user = new User(null, userPostRequest.getLoginUser(), userPostRequest.getNombre(),
				userPostRequest.getApellidos(), userPostRequest.getEmail(), userPostRequest.getPassword());
		return userRepository.create(user);
	}

	@Override
	public int updateUser(Long id, UserPostRequest userPostRequest) {
		
		User user = new User(id, userPostRequest.getLoginUser(), userPostRequest.getNombre(),
				userPostRequest.getApellidos(), userPostRequest.getEmail(), userPostRequest.getPassword());

		return userRepository.updateUser(user);

	}

	@Override
	public int deleteUserById(Long id) {
		int result = userRepository.deleteUserById(id);

		return result;
	}



}
