package ru.javavision.model;

import java.util.Set;

public class Car {
	
	private int id;
	private String mark;
	private Integer cost;
	private Set<Engine> engines;

	public Car() {
		super();
	}

	public Car(int id, String mark, Integer cost, Set<Engine> engines) {
		super();
		this.id = id;
		this.mark = mark;
		this.cost = cost;
		this.engines = engines;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Set<Engine> getEngines() {
		return engines;
	}

	public void setEngines(Set<Engine> engines) {
		this.engines = engines;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", mark=" + mark + ", cost=" + cost +"]";
	}
	

}
