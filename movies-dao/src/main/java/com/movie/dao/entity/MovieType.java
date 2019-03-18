package com.movie.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movies_types_tbl")
public class MovieType {
	private int mtid;
	private String name;
	private String description;
	private MovieEntity movie;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fmid", nullable = false)
	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getMtid() {
		return mtid;
	}

	public void setMtid(int mtid) {
		this.mtid = mtid;
	}

	@Column(length=10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=300)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MovieType [mtid=" + mtid + ", name=" + name + ", description=" + description + ", movie=" + movie + "]";
	}

}
