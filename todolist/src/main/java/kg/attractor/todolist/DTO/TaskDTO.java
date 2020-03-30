package kg.attractor.todolist.DTO;

import kg.attractor.todolist.model.Task;
import kg.attractor.todolist.model.TaskType;
import kg.attractor.todolist.model.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class TaskDTO {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    private String title;
    private String description;
    private String taskTime;
    private String tasksUser;
    private String tasksType;

    public static TaskDTO from(Task task){
        return builder().description(task.getDescription())
                .title(task.getTitle())
                .tasksType(task.getTasksType().toString())
                .taskTime(task.getTaskTime().format(dtf))
                .tasksUser(task.getTasksUser().getUsername())
                .build();
    }

}
