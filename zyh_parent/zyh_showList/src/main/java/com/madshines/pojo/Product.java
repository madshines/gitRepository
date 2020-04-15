package com.madshines.pojo;

public class Product {
	private int id;
	private String name;
	private String origin;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", origin=" + origin + "]";
	}
	
}
