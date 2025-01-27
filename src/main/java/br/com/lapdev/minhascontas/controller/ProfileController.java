package br.com.lapdev.minhascontas.controller;

import br.com.lapdev.minhascontas.dto.ProfileDTO;
import br.com.lapdev.minhascontas.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profile")
@CrossOrigin
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public List<ProfileDTO> getAll(){
        return profileService.getAll();
    }

    @PostMapping
    public void insert(@RequestBody ProfileDTO profile){
        profileService.insert(profile);
    }

    @PutMapping
    public ProfileDTO update(@RequestBody ProfileDTO profile){
        return profileService.update(profile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        profileService.delete(id);
        return ResponseEntity.ok().build();
    }





}
