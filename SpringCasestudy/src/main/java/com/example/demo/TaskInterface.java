package com.example.demo;

import java.util.List;

public interface TaskInterface {
	public Task getTask(int Task_Id);
	public List<Task> getAllTasks();
	public Task addTask(Object object);
	public List<Task> getAllTasksstatus(String status);
	public Task delete(int TaskId);
	public Task update(int TaskId,Task task);
	public Task setPriority(int TaskId,String priority);
	public Task setNotes(int TaskId,String notes);
	public Task setBookmark(int TaskId,Boolean isBookmarked);
	public Task assignTask(int TaskId,int ownerid);
	
	

}
