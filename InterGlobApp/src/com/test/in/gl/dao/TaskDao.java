package com.test.in.gl.dao;

import java.util.List;

import com.test.in.gl.dto.Task;


/**
 * Interface for Task related CRUD Operation
 * 
 * <br><br>
 * <b>Date</b> : March 25, 2018 
 * @author santosh.khule
 */
public interface TaskDao {
	public List<Task> getAllTask();
	public Task saveTask( Task task );
	public Task getTaskByTaskId( String taskId );
	public boolean deletTask( String taskId );	
}
