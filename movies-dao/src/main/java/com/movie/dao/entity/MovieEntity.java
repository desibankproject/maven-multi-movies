package com.movie.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // means save this object into database
@Table(name="hmovie_tbl")
public class MovieEntity {
	private int mid;
	private String title;
	private String year;
	private String director;
	private String language;
	private String story;
	private String poster;
	private byte[] photo;
	private List<MovieType> movieTypes;
	
	//mappedBy - this is not responsible to  maintain the relationship
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "movie")
	public List<MovieType> getMovieTypes() {
		return movieTypes;
	}

	public void setMovieTypes(List<MovieType> movieTypes) {
		this.movieTypes = movieTypes;
	}

	public MovieEntity() {
	}

	public MovieEntity(String title, String year, String director, String language, String story, String poster) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.language = language;
		this.story = story;
		this.poster = poster;
	}

	
	@Column(columnDefinition="longblob")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Column(length=1000)
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Column(length=250)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length=5)
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(length=100)
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Column(length=30)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(length=300)
	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "MovieEntity [mid=" + mid + ", title=" + title + ", year=" + year + ", director=" + director + ", language="
				+ language + ", story=" + story + ", poster=" + poster + "]";
	}

}
