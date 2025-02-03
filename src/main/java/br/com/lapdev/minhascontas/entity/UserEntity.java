package br.com.lapdev.minhascontas.entity;

import br.com.lapdev.minhascontas.dto.UserDTO;
import br.com.lapdev.minhascontas.entity.enums.UserSituationType;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "MC_USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true )
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserSituationType situation;

    public UserEntity(UserDTO user){
        BeanUtils.copyProperties(user,this);
    }

    public UserEntity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserSituationType getSituation() {
        return situation;
    }

    public void setSituation(UserSituationType situation) {
        this.situation = situation;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserEntity that = (UserEntity) object;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(login, that.login) && Objects.equals(password, that.password) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, email);
    }
}
