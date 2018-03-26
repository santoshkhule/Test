package com.test.in.gl.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.in.gl.dao.TaskDao;
import com.test.in.gl.dto.Task;

/**
 * TaskController does following : <br>
 * <ol> 1.Fetch All tasks </ol>
 * <ol> 2. Save/Update tasks </ol>
 * <ol> 3. Delete task </ol>
 * 
 * <b>Date</b> : March 27, 2018
 * @author Santosh.khule
 *
 */
@Controller
@RequestMapping("/")
public class TaskController {
	
	@Autowired
	TaskDao taskDao;
	
	@RequestMapping( value = "/task", method = RequestMethod.GET )	
	public void getAllTask( HttpServletRequest request, 
			HttpServletResponse response ) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonTaskList = gson.toJson(taskDao.getAllTask());
		System.out.println( jsonTaskList );
		response.getWriter().write(jsonTaskList);		
	}
	
	@RequestMapping( value = "/task", method = RequestMethod.POST )	
	public void saveTask( HttpServletRequest request, 
			HttpServletResponse response, @RequestBody Task task ) throws IOException {
		// save operation
		taskDao.saveTask(task);
		
		// getting list of task and preparing response for User
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonTaskList = gson.toJson( taskDao.getAllTask() );
		response.getWriter().write( jsonTaskList );	
	}
	
	@RequestMapping( value = "/task/{taskId}", method = RequestMethod.DELETE )	
	public void deleteTask( HttpServletRequest request, 
			HttpServletResponse response, @PathVariable("taskId") String taskId ) throws IOException {
		// delete operation
		taskDao.deletTask( taskId );
		
		// getting list of task and preparing response for User
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonTaskList = gson.toJson( taskDao.getAllTask() );
		response.getWriter().write( jsonTaskList );	
	}

	
}