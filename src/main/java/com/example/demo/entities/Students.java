package com.example.demo.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Students 
{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String standard;
	private String address;
	public Students(int id, String name, String standard, String address) {
		super();
		this.id = id;
		this.name = name;
		this.standard = standard;
		this.address = address;
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", standard=" + standard + ", address=" + address + "]";
	}
	

}
