package com.movie.rest.api.controller;

public class MovieTypeVO {
	private int mid;
	private String name;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MovieTypeVO [mid=" + mid + ", name=" + name + "]";
	}

}
