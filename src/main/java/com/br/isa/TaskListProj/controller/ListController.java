package com.br.isa.TaskListProj.controller;

import com.br.isa.TaskListProj.model.TaskEntity;
import com.br.isa.TaskListProj.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/taskList")
@RequiredArgsConstructor
public class ListController {

    private final ListService taskService;

    //Creates a new Task object
    @PostMapping("/addTask")
    @ResponseStatus(HttpStatus.OK)
    public String addTask(@RequestBody TaskEntity tarefa){
        return taskService.add(tarefa);
    }

    //Lists all created tasks
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskEntity> listTasks(){
        return taskService.list();
    }

    //Lists only the tasks for the specified day of the week
    @GetMapping("/listDailyTasks/{dayOfWeek}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskEntity> listDailyTasks(@PathVariable String dayOfWeek){
        return taskService.listDailyTasks(dayOfWeek);
    };

    //Deletes the task for the specified id
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTask(@PathVariable int id){
        return taskService.delete(id);
    }

    //Fully updates the task with the specified day of the week and id
    @PutMapping("/update/{dayOfWeek}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateTask(@PathVariable String dayOfWeek, @PathVariable int id, @RequestBody TaskEntity task){
        return taskService.update(dayOfWeek,id,task);
    }

    //Updates only the status of the task with the specified day of the week and id
    @PatchMapping("/updateStaus/{dayOfWeek}/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateStatus(@PathVariable String dayOfWeek, @PathVariable int id, @RequestBody TaskEntity task){
        return taskService.updateStatus(dayOfWeek,id,task);
    }
}

