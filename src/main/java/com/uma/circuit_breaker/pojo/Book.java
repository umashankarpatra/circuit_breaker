package com.uma.circuit_breaker.pojo;

import java.io.Serializable;

public class Book implements Serializable {
	
	private static final long serialVersionUID = -5933882633489466961L;
	private String id;
	private String name;


	public Book() {

	}

	public Book(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
}
