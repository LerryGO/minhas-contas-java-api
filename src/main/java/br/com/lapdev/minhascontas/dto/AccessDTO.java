package br.com.lapdev.minhascontas.dto;

public class AccessDTO {
    private String token;

    //TODO implementar retornar o usuario e liberacoes (authorities)

    public AccessDTO(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
