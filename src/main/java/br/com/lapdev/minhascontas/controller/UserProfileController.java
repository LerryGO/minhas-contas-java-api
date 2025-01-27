package br.com.lapdev.minhascontas.controller;

import br.com.lapdev.minhascontas.dto.UserProfileDTO;
import br.com.lapdev.minhascontas.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user-profile")
@CrossOrigin
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    public List<UserProfileDTO> getAll(){
        return userProfileService.getAll();
    }

    @PostMapping
    public void insert(@RequestBody UserProfileDTO userProfile){
        userProfileService.insert(userProfile);
    }

    @PutMapping
    public UserProfileDTO update(@RequestBody UserProfileDTO userProfile){
        return userProfileService.update(userProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userProfileService.delete(id);
        return ResponseEntity.ok().build();
    }
}
