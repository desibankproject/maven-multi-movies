package com.movie.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Movie {

	private int mid;
	private String title;
	private String year;
	private String director;
	private String language;
	private String story;
	private String poster;
	@JsonIgnore
	private byte[] photo;
	private List<Type> types;

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public Movie() {
	}

	public Movie(String title, String year, String director, String language, String story, String poster) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.language = language;
		this.story = story;
		this.poster = poster;
	}
	

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", title=" + title + ", year=" + year + ", director=" + director + ", language="
				+ language + ", story=" + story + ", poster=" + poster + "]";
	}

}
