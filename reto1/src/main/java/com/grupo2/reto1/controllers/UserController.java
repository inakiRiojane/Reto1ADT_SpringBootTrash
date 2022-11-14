package com.grupo2.reto1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.reto1.modelos.favoriteModelo.FavoriteGetResponse;
import com.grupo2.reto1.modelos.songModelo.SongGetResponse;
import com.grupo2.reto1.modelos.userModelo.LoginGetResponse;
import com.grupo2.reto1.modelos.userModelo.LoginPostRequest;
import com.grupo2.reto1.modelos.userModelo.User;
import com.grupo2.reto1.modelos.userModelo.UserGetResponse;
import com.grupo2.reto1.modelos.userModelo.UserPostRequest;
import com.grupo2.reto1.security.JwtTokenUtil;
import com.grupo2.reto1.services.userService.UserService;

@RequestMapping("api")
@RestController
public class UserController {
	
	@Autowired
	UserService userService ;
	
	@Autowired 
	AuthenticationManager authManager;
	
	@Autowired 
	JwtTokenUtil jwtUtil;
	
//	@PostMapping("/user/login")
//	public ResponseEntity<?> login(@RequestBody @Valid LoginPostRequest request) {		
//		try {
//			Authentication authentication = authManager.authenticate(
//					new UsernamePasswordAuthenticationToken(request.getLoginUser(), request.getPassword())
//					
//					
//			);
////			String hola = request.getLoginUser().toString();
////			String adios =request.getPassword().toString();
////			System.out.printf(hola, adios);
//			
//			User user = (User) authentication.getPrincipal();
//			String accessToken = jwtUtil.generateAccessToken(user);
//			LoginGetResponse response = new LoginGetResponse(user.getLoginUser(), accessToken);
//			System.out.println(response.toString());
//			
//			return ResponseEntity.ok().body(response);
//			
//		} catch (BadCredentialsException ex) {
//			System.out.println(ex);
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//		}
//	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {

		UserGetResponse userGetResponse = userService.getUserById(id);
		return new ResponseEntity<UserGetResponse>(userGetResponse, HttpStatus.OK);
	}
	
	@PostMapping("/user/signup")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserPostRequest userPostRequest) {

		return new ResponseEntity<Integer>(userService.createUser(userPostRequest), HttpStatus.CREATED);
	}	

	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Long id,
										@RequestBody UserPostRequest userPostRequest) {

		userService.updateUser(id, userPostRequest);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {

		userService.deleteUserById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

	
//	// utilizamos el /me por que vamos a coger el nuestro
//	// TE DEVUELVE 
//		@GetMapping("/auth/me")
//		public ResponseEntity<?> getUserInfo(Authentication authentication) {
//			// aqui podemos castearlo a UserDetails o User. El UserDetails es una interfaz, 
//			// si lo casteamos a la interfaz no podremos sacar campos como la ID
//			User userDetails = (User) authentication.getPrincipal();
//			
//			//TODO userDetails.getId(); --> PARA COJER LA ID DEL USUARIO ACTUALMENTE LOGUEADO	
//			
//			// aqui podriamos devolver datos del usuario. quizá no sea lo que queremos devolver o no lo querramos devolver
//			// es un ejemplo por que con userDetails.getId() tendríamos la ID del usuario sin que la pase por parametro
//			// necesario en algunos servicios: si quiero devolver una lista o elemento privado del usuario, no voy a querer
//			// que el usuario mande su ID por parametro. Ya que es trampeable.
//			// de ahi que sea "/me" en el ejemplo
//			
//			return ResponseEntity.ok().body(userDetails);
//		}

}
