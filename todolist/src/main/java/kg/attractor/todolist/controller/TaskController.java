package kg.attractor.todolist.controller;

import kg.attractor.todolist.DTO.TaskDTO;
import kg.attractor.todolist.annotations.ApiPageable;
import kg.attractor.todolist.model.Task;
import kg.attractor.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService ts;

    @ApiPageable
    @GetMapping
    public Slice<TaskDTO> findTasks(Pageable p ){
        return ts.findTasks(p);
    }

    @GetMapping("/myTasks")
    public List<Task> getTasks(@RequestParam("email") String email, @ApiIgnore Pageable pageable){
        return ts.findAllByTasksUser(email, pageable);
    }

//    @PostMapping("/addTask")
//    public Task addTask(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("date") String date ){
//        return  ts.setTask(title,description, LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
//
//    }
}
