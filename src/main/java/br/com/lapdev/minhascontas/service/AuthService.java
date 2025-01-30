package br.com.lapdev.minhascontas.service;

import br.com.lapdev.minhascontas.dto.AccessDTO;
import br.com.lapdev.minhascontas.dto.AuthenticationDTO;
import br.com.lapdev.minhascontas.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AccessDTO login(AuthenticationDTO authDTO){

        try {
            //Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());

            //Prepara mecanismo para autenticacao
            Authentication authentication = authenticationManager.authenticate(userAuth);

            //Busca usuario logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            return new AccessDTO(token);

        }catch(BadCredentialsException e) {
            //TODO LOGIN OU SENHA INVALIDO
        }
        return new AccessDTO("Acesso negado");
    }
}
