package com.mb.trello.model;

public class Model {
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + "]";
	}
	
}
