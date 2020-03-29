package kg.attractor.todolist.repository;

import kg.attractor.todolist.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepo extends PagingAndSortingRepository<Task, String> {
}
