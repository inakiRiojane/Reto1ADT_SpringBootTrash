package com.grupo2.reto1.modelos.songModelo;

import java.net.URL;

public class Song {

	private Long id;
	private String titulo;
	private String autor;
	private String url;
	
	public Song() {
		
	}

	public Song(Long id, String titulo, String autor, String url) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", url=" + url + "]";
	}
}