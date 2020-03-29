package kg.attractor.todolist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Document(collection = "tasks")
public class Task {
    @Id
    private String id = UUID.randomUUID().toString();
    private String title;
    private String description;
    private LocalDate taskTime;
    @DBRef
    private User tasksUser;
    private String tasksStatus;
}
