package kg.attractor.todolist.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id = UUID.randomUUID().toString();
    private String userName;
    private String email;
    private String password;

    public User(String user, String email, String password){
        this.userName = user;
        this.email=email;
        this.password=password;

    }

}
