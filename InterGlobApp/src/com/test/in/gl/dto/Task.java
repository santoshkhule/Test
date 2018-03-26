package com.test.in.gl.dto;

/**
 * DTO for <code>Task</code>
 * 
 * <br><br>
 * <b>Date</b> : March 25, 2018
 * @author santosh.khule
 */
public class Task {
	private String id;
	private String name;
	private String status;
	
	public Task() {}
	
	public Task ( String id, String name , String status ) {
		this.id = id;
		this.name = name;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
}
