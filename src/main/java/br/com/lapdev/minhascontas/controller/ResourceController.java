package br.com.lapdev.minhascontas.controller;

import br.com.lapdev.minhascontas.dto.ResourceDTO;
import br.com.lapdev.minhascontas.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/resource")
@CrossOrigin
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<ResourceDTO> getAll(){
        return resourceService.getAll();
    }

    @PostMapping
    public  void insert(ResourceDTO resource){
        resourceService.insert(resource);
    }

    @PutMapping
    public  ResourceDTO update(@RequestBody ResourceDTO resource){
        return resourceService.update(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        resourceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
