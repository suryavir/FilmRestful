package com.samson.RestfulService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.samson.RestfulService.BO.FilmBO;
import com.samson.RestfulService.services.FilmServices;
import com.samson.RestfulService.services.IFilmServices;

@Controller
@RestController
public class HomeController {
	
	@Autowired
	IFilmServices filmservices;

	public void setFilmservices(IFilmServices filmservices) {
		this.filmservices = filmservices;
	}

	@RequestMapping(value="/films",method=RequestMethod.GET,headers="Accept=application/json")
	public List<FilmBO> getFilms(){
		return (filmservices.findAllFilms());
	}
	
	@RequestMapping(value="/films/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	public FilmBO getFilmsById(@PathVariable("id") int id){
		
		return (filmservices.findFilmById(id));
	}
	
	@RequestMapping(value="/films/insert/", method=RequestMethod.POST)
	public List<FilmBO> insertFilms(@ModelAttribute("filmbo") FilmBO filmbo)
	{
		System.out.println("title is"+filmbo.getTitle());
		return (filmservices.insertFilm(filmbo));
		
	}
}
