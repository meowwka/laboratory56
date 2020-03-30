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
            users.add(new User("Taazim","taazim@gmail.com","taazim"));
            users.add(new User("meow","meow@gmail.com","meow"));
            users.add(new User("Anton","anton@gmail.com","anton"));
            users.add(new User("Nastya","nastya@gmail.com","nastya"));

            userRepo.saveAll(users);

//
//            List<Task> taskss =
//            taskRepo.saveAll(taskss);

            List<Task> tasks =  new ArrayList<>();
//                    Stream.generate(Task::random).limit(10)
//                    .collect(toList());;

            users.forEach(user -> tasks.add(Task.random(user)));
            taskRepo.saveAll(tasks);

        };


    }





}
