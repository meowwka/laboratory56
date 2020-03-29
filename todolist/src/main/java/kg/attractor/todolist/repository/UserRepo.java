package kg.attractor.todolist.repository;

import kg.attractor.todolist.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User,String> {
}
