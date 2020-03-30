package kg.attractor.todolist.service;

import kg.attractor.todolist.DTO.TaskDTO;
import kg.attractor.todolist.model.Task;
import kg.attractor.todolist.model.User;
import kg.attractor.todolist.repository.TaskRepo;
import kg.attractor.todolist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    @Autowired
    private TaskRepo tr;
    @Autowired
    private UserRepo uRepo;

    public Slice<TaskDTO> findTasks(Pageable pageable){
        var slice = tr.findAll(pageable);
        return slice.map(TaskDTO::from);
    }

    public Task setTask(String title, String description, LocalDateTime date) {
        return tr.save(new Task(title,description,date));
    }

    public List<Task> findAllByTasksUser(String s, Pageable p){
        return tr.findAllByTasksUserEmail(s,p).stream().filter(u -> u.getTasksUser().getEmail().equals(this.getUser().getEmail())).collect(Collectors.toList());
    }


    private User getUser() {
        // get current authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return uRepo.findByEmail(auth.getName()).get();
    }

    public Slice<TaskDTO> findById(String id,Pageable p ){
        return tr.findAllById(id,p).map(TaskDTO::from);
    }

//    public TaskDTO addTask(TaskDTO taskDTO){
//        var task = Task.builder().title(taskDTO.getTitle())
//                .description(taskDTO.getDescription())
//                .taskTime(taskDTO.getTaskTime())
//                .build();
//        tr.save(task);
//        return TaskDTO.fromm(task);
//
//    }
}
