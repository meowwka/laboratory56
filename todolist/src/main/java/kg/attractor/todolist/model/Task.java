package kg.attractor.todolist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Data
@Document(collection = "tasks")
public class Task {
    private static final Random r = new Random();
    @Id
    private String id = UUID.randomUUID().toString();
    private String title;
    private String description;
    private LocalDate taskTime;
    @DBRef
    private User tasksUser;
    private TaskType tasksType;

    public Task(String id, String title, String description, LocalDate taskTime, User tasksUser, TaskType tasksType) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskTime = taskTime;
        this.tasksUser = tasksUser;
        this.tasksType = tasksType;
    }
}
