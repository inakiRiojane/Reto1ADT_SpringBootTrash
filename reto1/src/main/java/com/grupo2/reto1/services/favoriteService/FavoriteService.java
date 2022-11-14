package com.grupo2.reto1.services.favoriteService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;

import com.grupo2.reto1.modelos.favoriteModelo.FavoriteGetResponse;
import com.grupo2.reto1.modelos.favoriteModelo.FavoritePostRequest;
import com.grupo2.reto1.modelos.songModelo.Song;
import com.grupo2.reto1.modelos.songModelo.SongGetResponse;

public interface FavoriteService {

	List<FavoriteGetResponse> getAllFavorites();
	List<FavoriteGetResponse> getFavoriteById(Long id);
	int createFavorite(FavoritePostRequest favoritePostRequest);
	int updateFavoriteById(Long id, FavoritePostRequest favoritePostRequest);
	int deleteFavoriteById(Long idSong, Long idUser);
	List<SongGetResponse> getFavoriteByUserId(Long id);

}
