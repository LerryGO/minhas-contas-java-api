package br.com.lapdev.minhascontas.dto;

import br.com.lapdev.minhascontas.entity.UserEntity;
import br.com.lapdev.minhascontas.entity.enums.UserSituationType;
import org.springframework.beans.BeanUtils;

public class UserDTO {
    private Long id;
    private String name;
    private String login;
    private String password;
    private String email;
    private UserSituationType situation;

    public UserDTO(UserEntity user){
        BeanUtils.copyProperties(user,this);
    }

    public UserDTO(){}

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
}
