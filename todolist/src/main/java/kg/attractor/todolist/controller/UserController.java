package kg.attractor.todolist.controller;

import kg.attractor.todolist.DTO.UserDTO;
import kg.attractor.todolist.annotations.ApiPageable;
import kg.attractor.todolist.model.Task;
import kg.attractor.todolist.model.User;
import kg.attractor.todolist.service.TaskService;
import kg.attractor.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService us;
    @Autowired
    private TaskService ts;

    @ApiPageable
    @GetMapping
    public Slice<UserDTO> findUsers(@ApiIgnore Pageable pageable){
        return us.findUsers(pageable);
    }

    @PostMapping("/add")
    public User saveNewUser( @RequestParam("name") String name, @RequestParam("email") String email,@RequestParam("password") String password) {
        return us.setUsers(name, email,password);
    }




}
