package com.test.in.gl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.in.gl.dao.TaskDao;
import com.test.in.gl.dto.Task;

/**
 * Implementation class for <code>TaskDao</code> interfaces
 *  
 * <br><br>
 * <b>Date</b> : March 26, 2018
 * @author Santosh.khule
 *	
 */
@Repository
public class TaskDaoImpl implements TaskDao {
	
	// Sql Queries for task related CRUD operation
	private static String TASK_MAX_ID = "select max( id ) from task";
	private static String TASK_SELECT_ALL = "select id,name,status from task";
	private static String TASK_INSERT = "insert into task values ( ?,?,?)";
	private static String TASK_UPDATE = "update task set name = ?, status=? where id = ?";
	private static String TASK_DELETE = "delete from task where id=?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Task> getAllTask() {
		List<Task> taskList = new ArrayList<>();		
		taskList = jdbcTemplate.query( TASK_SELECT_ALL, 
			new BeanPropertyRowMapper( Task.class ));
		return taskList;
	}

	
	@Override
	public Task saveTask( Task task ) {
		
		if ( task.getId() == null ) {
			
			Integer maxId = jdbcTemplate.queryForObject( TASK_MAX_ID, Integer.class );			
			if ( maxId !=null )	maxId++;
			else maxId = 1;	
			
			jdbcTemplate.update( TASK_INSERT, maxId, task.getName(), task.getStatus());
			task.setId( String.valueOf( maxId ) );
			
		} else {	
			
			jdbcTemplate.update( TASK_UPDATE, task.getName(), task.getStatus(), task.getId());
			
		}		
		return task;
	}
	
	@Override
	public boolean deletTask( String taskId ) {		
		jdbcTemplate.update( TASK_DELETE, taskId  );
		return true;
	}
	
	@Override
	public Task getTaskByTaskId( String taskId ) {
		return null;
	}
	
	/**
	 * Get Max id for required table
	 * 
	 * @return maxId
	 */
	public Integer getMaxId ( String tableName ) {
		Integer maxId = 0;		
		maxId = jdbcTemplate.queryForObject("select max(id) from task", Integer.class );
		return maxId++;
	}
}
