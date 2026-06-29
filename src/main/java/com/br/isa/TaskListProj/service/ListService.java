package com.br.isa.TaskListProj.service;

import com.br.isa.TaskListProj.model.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ListService {

    public List<TaskEntity> taskList = new ArrayList<>();


    public List<TaskEntity> list(){
        return taskList;
    }

    public String add(TaskEntity task){
        taskList.add(task);
        return "Task added successfully";
    }

    public List<TaskEntity> listDailyTasks(String dayOfWeek){
        List<TaskEntity> tasks = new ArrayList<>();
        for (TaskEntity task: taskList){
            if (task.getDayOfWeek().equalsIgnoreCase(dayOfWeek)){
                tasks.add(task);
            }
        }
        return tasks;
    }

    public String delete(int id){
        for (TaskEntity task : taskList){
            if (task.getId() == id ){
                taskList.remove(task);
                return "Task deleted successfully";
            }
        }
        return "Task not found";
    }

    public String update(String dayOfWeek, int id, TaskEntity t) {
        for (TaskEntity task : taskList) {
            if (task.getDayOfWeek().equalsIgnoreCase(dayOfWeek) && task.getId() == id) {
                task.setId(t.getId());
                task.setName(t.getName());
                task.setDescription(t.getDescription());
                task.setDayOfWeek(t.getDayOfWeek());
                task.setCategory(t.getCategory());
                task.setStatus(t.getStatus());
                return "Task updated successfully!";
            }
        }
        return "Task not found";
    }

    public String updateStatus (String dayOfWeek, int id, TaskEntity t){
        for (TaskEntity task: taskList){
            if (task.getDayOfWeek().equalsIgnoreCase(dayOfWeek) && task.getId() == id){
                task.setStatus(t.getStatus());
                return "Status updated successfully!";
            }
        }
        return "Task not found";
    }
}

