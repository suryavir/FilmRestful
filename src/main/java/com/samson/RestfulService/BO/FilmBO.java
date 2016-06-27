package com.samson.RestfulService.BO;

public class FilmBO {
	
	private int film_id;
	private String title;
	private String description;
	private int release_year;
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	@Override
	public String toString() {
		return "FilmBO [film_id=" + film_id + ", title=" + title
				+ ", description=" + description + ", release_year="
				+ release_year + "]";
	}
	
	

}
