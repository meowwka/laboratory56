package kg.attractor.todolist.repository;

import kg.attractor.todolist.model.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskRepo extends PagingAndSortingRepository<Task, String> {
    public List<Task> findAllByTasksUserEmail(String email, Pageable pageable);
}
