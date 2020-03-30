package kg.attractor.todolist.util;

import kg.attractor.todolist.model.Task;
import kg.attractor.todolist.model.User;
import kg.attractor.todolist.repository.TaskRepo;
import kg.attractor.todolist.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class InitDataBase {

    @Bean
    CommandLineRunner init(UserRepo userRepo, TaskRepo taskRepo){
        return (args) ->{
            userRepo.deleteAll();
            taskRepo.deleteAll();

            List<User> users = new ArrayList<>();
            users.add(new User("Anna","anna@gmail.com","password"));
            users.add(new User("Taazim","Taazim@gmail.com","taazim"));
            users.add(new User("meow","Taazim@gmail.com","taazim"));

            userRepo.saveAll(users);


            List<Task> tasks = new ArrayList<>();
            users.forEach(user -> tasks.add(Task.random(user)));
            taskRepo.saveAll(tasks);

        };


    }





}
