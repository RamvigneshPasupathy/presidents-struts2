package com.sam.bean;

public class Country {
	
	private int id;
	
	private String name;
	
	private String president;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}
	
	@Override
	public String toString() {
		return "id: " + this.id + " | " + "name: " + this.name + " | " + "president: " + this.president;
	}

}
