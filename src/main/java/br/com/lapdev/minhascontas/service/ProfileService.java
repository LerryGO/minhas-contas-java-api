package br.com.lapdev.minhascontas.service;

import br.com.lapdev.minhascontas.dto.ProfileDTO;
import br.com.lapdev.minhascontas.dto.ResourceDTO;
import br.com.lapdev.minhascontas.entity.ProfileEntity;
import br.com.lapdev.minhascontas.entity.ResourceEntity;
import br.com.lapdev.minhascontas.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileDTO> getAll(){
        List<ProfileEntity> profiles = profileRepository.findAll();
        return profiles.stream().map((ProfileEntity::new)).toList();
    }

    public void insert(ProfileDTO profile){
        ProfileEntity ProfileEntity = new ProfileEntity(profile);
        profileRepository.save(ProfileEntity);
    }

    public ProfileDTO update(ProfileDTO profile){
        ProfileEntity resourceEntity = new ProfileEntity(profile);
        return new ProfileDTO(profileRepository.save(resourceEntity));
    }

    public void delete(Long id){
        Optional<ProfileEntity> profile = profileRepository.findById(id);
        profile.ifPresent(userEntity -> profileRepository.delete(userEntity));
    }

    public ProfileDTO findById(Long id){
        Optional<ProfileEntity> profile = profileRepository.findById(id);
        if(profile.isPresent()){
            return  new ProfileDTO(profileRepository.findById(id).orElse(null));
        }
        return null;
    }
}
