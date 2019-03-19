package com.movie.model;

public class Type {
	private int mtid;
	private String name;
	private String description;
	

	public int getMtid() {
		return mtid;
	}

	public void setMtid(int mtid) {
		this.mtid = mtid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Type [mtid=" + mtid + ", name=" + name + ", description=" + description + "]";
	}


}
