package kg.attractor.todolist.model;

import kg.attractor.todolist.util.Generator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Data
@Document(collection = "tasks")
@Builder
@AllArgsConstructor

public class Task {
    private static final Random r = new Random();
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String title;
    private String description;
    private LocalDateTime taskTime;
    @DBRef
    private User tasksUser;
    private TaskType tasksType;

    public Task( String title, String description, LocalDateTime taskTime, User tasksUser, TaskType tasksType) {
        this.title = title;
        this.description = description;
        this.taskTime = taskTime;
        this.tasksUser = tasksUser;
        this.tasksType = tasksType;
    }
    public static Task random(User user){
        return  builder()
                .description(Generator.makeDescription())
                .tasksUser(user)
                .title(Generator.makeTitle())
                .tasksType(TaskType.values()[r.nextInt(3)])
                .taskTime(LocalDateTime.now())
                .build();
    }
}
