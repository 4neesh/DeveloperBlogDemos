package com.aneesh.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ToDoDeserialiser.class)
public class ToDo{

	private int userId;
    private int id;
    private String title;
    private String completed;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	public ToDo(int userId, int id, String title, String completed) {
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.completed = completed;
	}
    
    
}
