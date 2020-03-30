package kg.attractor.todolist.model;

import kg.attractor.todolist.util.Generator;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class User implements UserDetails {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String userName;
    private String email;
    private String password;

    public  User(String user, String email, String password){
        this.userName = user;
        this.email=email;
        this.password=password;

    }

    public static User random(){
    return  builder().userName(Generator.makeName())
            .email(Generator.makeEmail())
            .password(Generator.makePassword())
            .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
