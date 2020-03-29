package kg.attractor.todolist.DTO;

import kg.attractor.todolist.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String userName;
    private String email;
    private String password;

    public static UserDTO from(User user){
        return builder().userName(user.getUserName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

    }
}
