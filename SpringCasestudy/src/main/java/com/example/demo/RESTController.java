package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//@CrossOrigin(origins="http://localhost:4200/")
@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class RESTController {
	@Autowired
	TaskInterface dao;
	@Autowired
	UserInterface userdao;

	@RequestMapping(value="/gettask/{TaskId}",method=RequestMethod.GET,produces= {"application/json"})
	public Task getTask(@PathVariable int TaskId) throws SQLException
	{
		return dao.getTask(TaskId);
	}
	@RequestMapping(value="/deletetask/{TaskId}",method=RequestMethod.DELETE,produces= {"application/json"})
	public Task deleteTask(@PathVariable int TaskId) throws SQLException
	{
		return dao.delete(TaskId);
	}
	@RequestMapping(value="/listtask",method=RequestMethod.GET,produces= {"application/json"})
	public List<Task> getAllTasks()
	{
		return dao.getAllTasks();
	}

	@PostMapping(value= "/addtask", consumes = "application/json", produces = "application/json")
	public Task addTask(@RequestBody Task task) throws Exception
	{
		dao.addTask(task);
		return task;
		
	}
	@PostMapping(value= "/adduser", consumes = "application/json", produces = "application/json")
	public User addUser(@RequestBody User user) throws Exception
	{
		userdao.addUser(user);
		return user;
		
	}
	@PostMapping(value= "/validateuser", consumes = "application/json", produces = "application/json")
	public boolean validateuser(@RequestBody User user) throws Exception
	{
		return userdao.validateuser(user); 
		
	}
	@RequestMapping(value="/trackstatus/status/{Status}",method=RequestMethod.GET,produces= {"application/json"})
	public List<Task> getAllTasksstatus(@PathVariable String Status) throws SQLException
		{
			return dao.getAllTasksstatus(Status);
		}
//	@PutMapping("/updatetask/{TaskId}")
	@RequestMapping(value="/updatetask/{TaskId}",method=RequestMethod.PUT,produces= {"application/json"})
	public Task update(@PathVariable int TaskId,@RequestBody Task task) throws SQLException
	{	
		 return dao.update(TaskId,task);
	}
	@RequestMapping(value="/updatepriority/{TaskId}/{priority}",method=RequestMethod.GET,produces= {"application/json"})
	public Task getUpdatepri(@PathVariable int TaskId,@PathVariable String priority) throws SQLException
	{
		return dao.setPriority(TaskId,priority);
	}

	@RequestMapping(value="/updatenotes/{TaskId}/{notes}",method=RequestMethod.GET,produces= {"application/json"})
	public Task getUpdatenot(@PathVariable int TaskId,@PathVariable String notes) throws SQLException
	{
		return dao.setNotes(TaskId,notes);
	}
	@RequestMapping(value="/updateisbookmarked/{TaskId}/{isBookmarked}",method=RequestMethod.GET,produces= {"application/json"})
	public Task getUpdatebook(@PathVariable int TaskId,@PathVariable Boolean isBookmarked) throws SQLException
	{
		return dao.setBookmark(TaskId,isBookmarked);
	}
	@RequestMapping(value="/assigntaskuser/{TaskId}/{ownerid}",method=RequestMethod.GET,produces= {"application/json"})
	public Task getUpdatebook(@PathVariable int TaskId,@PathVariable int ownerid) throws SQLException
	{
		return dao.assignTask(TaskId,ownerid);
	}
}
