package kg.attractor.todolist.repository;

import kg.attractor.todolist.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepo extends PagingAndSortingRepository<User,String> {
    public Optional<User> findByUserName(String s);
    public Optional<User> findByEmail(String email);
    Slice<User> findUserByEmail(String email, Pageable pageable);

}
