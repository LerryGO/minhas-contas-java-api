package br.com.lapdev.minhascontas.controller;

import br.com.lapdev.minhascontas.dto.AuthenticationDTO;
import br.com.lapdev.minhascontas.dto.UserDTO;
import br.com.lapdev.minhascontas.service.AuthService;
import br.com.lapdev.minhascontas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDTO){
        return ResponseEntity.ok(authService.login(authDTO));
    }

    @PostMapping(value = "/register")
    public void registerUser(@RequestBody UserDTO newUser){
        userService.registerUser(newUser);
    }

    @GetMapping(value = "/checkRegistration/{uuid}")
    public String checkRegistration(@PathVariable("uuid") String uuid){

        return  userService.checkRegistration(uuid);
    }

}
