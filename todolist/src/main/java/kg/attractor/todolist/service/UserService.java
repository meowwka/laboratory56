package kg.attractor.todolist.service;

import kg.attractor.todolist.DTO.UserDTO;
import kg.attractor.todolist.model.User;
import kg.attractor.todolist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo uRepo;

    public Slice<UserDTO> findUsers(Pageable pageable) {
        var slice = uRepo.findAll(pageable);
        return slice.map(UserDTO::from);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = uRepo.findByEmail(s);
        if (user.isPresent())
            return  user.get();

        throw new UsernameNotFoundException("User does not exit");
    }

    public User setUsers(String name, String email, String password) {
        return uRepo.save(new User(name, email,password));
    }
    private User getUser() {
        // get current authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return uRepo.findByEmail(auth.getName()).get();
    }
}
