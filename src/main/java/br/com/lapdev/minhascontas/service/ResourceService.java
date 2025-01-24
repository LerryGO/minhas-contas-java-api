package br.com.lapdev.minhascontas.service;

import br.com.lapdev.minhascontas.dto.ResourceDTO;
import br.com.lapdev.minhascontas.dto.UserDTO;
import br.com.lapdev.minhascontas.entity.ResourceEntity;
import br.com.lapdev.minhascontas.entity.UserEntity;
import br.com.lapdev.minhascontas.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<ResourceDTO> getAll(){
        List<ResourceEntity> resources = resourceRepository.findAll();
        return resources.stream().map((ResourceDTO::new)).toList();
    }

    public void insert(ResourceDTO resource){
        ResourceEntity resourceEntity = new ResourceEntity(resource);
        resourceRepository.save(resourceEntity);
    }

    public ResourceDTO update(ResourceDTO resource){
        ResourceEntity resourceEntity = new ResourceEntity(resource);
        return new ResourceDTO(resourceRepository.save(resourceEntity));
    }

    public void delete(Long id){
        Optional<ResourceEntity> resource = resourceRepository.findById(id);
        resource.ifPresent(userEntity -> resourceRepository.delete(userEntity));
    }

    public ResourceDTO findById(Long id){
        Optional<ResourceEntity> user = resourceRepository.findById(id);
        if(user.isPresent()){
            return  new ResourceDTO(resourceRepository.findById(id).orElse(null));
        }
        return null;
    }
}
