package com.samson.RestfulService.services;

import java.util.List;

import com.samson.RestfulService.BO.FilmBO;

public interface IFilmServices {
	
	public List<FilmBO> findAllFilms();
	public FilmBO findFilmById(int id);
	public List<FilmBO> insertFilm(FilmBO bo);
	public List<FilmBO> deleteFilm(int id);

}
