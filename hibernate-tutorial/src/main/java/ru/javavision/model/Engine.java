package ru.javavision.model;


import java.util.Set;


public class Engine {
	private int id;
	private String name;
	private int power;
	private Set<Car> cars;

	
	public Engine() {
		super();
	}
	
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
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "Engine [id=" + id + ", name=" + name + ", power=" + power + "]";
	}

	

	
}
