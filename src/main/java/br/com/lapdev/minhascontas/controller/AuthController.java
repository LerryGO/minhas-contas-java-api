package br.com.lapdev.minhascontas.controller;

import br.com.lapdev.minhascontas.dto.AuthenticationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDTO){

    }
}
