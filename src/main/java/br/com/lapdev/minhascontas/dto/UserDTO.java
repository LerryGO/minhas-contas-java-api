package br.com.lapdev.minhascontas.dto;

import br.com.lapdev.minhascontas.entity.UserEntity;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

public class UserDTO {
    private Long id;
    private String nome;
    private String login;
    private String password;
    private String email;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
