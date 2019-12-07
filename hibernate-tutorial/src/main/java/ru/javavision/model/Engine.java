package ru.javavision.model;


import java.io.Serializable;
import java.util.Set;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Engine {
	private int id;
	private String name;
	private int power;
	private String carMark;
	private Set<Car> cars;

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
	public String getCarMark() {
		return carMark;
	}
	public void setCarMark(String carMark) {
		this.carMark = carMark;
	}
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "Engine [id=" + id + ", name=" + name + ", power=" + power + ", carMark=" + carMark + ", cars=" + cars
				+ "]";
	}

	

	
}
