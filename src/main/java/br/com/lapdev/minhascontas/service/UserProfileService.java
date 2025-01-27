package br.com.lapdev.minhascontas.service;

import br.com.lapdev.minhascontas.dto.UserDTO;
import br.com.lapdev.minhascontas.dto.UserProfileDTO;
import br.com.lapdev.minhascontas.entity.UserProfileEntity;
import br.com.lapdev.minhascontas.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<UserProfileDTO> getAll(){
        List<UserProfileEntity> users = userProfileRepository.findAll();
        return  users.stream().map(UserProfileDTO::new).toList();
    }

    public void insert(UserProfileDTO user){
        UserProfileEntity userProfileEntity = new UserProfileEntity(user);
        userProfileRepository.save(userProfileEntity);
    }

    public UserProfileDTO update(UserProfileDTO user){
        UserProfileEntity userProfileEntity = new UserProfileEntity(user);
        return new UserProfileDTO(userProfileRepository.save(userProfileEntity));
    }

    public void delete(Long id){
        Optional<UserProfileEntity> user = userProfileRepository.findById(id);
        user.ifPresent(userProfileEntity -> userProfileRepository.delete(userProfileEntity));
    }

    public UserProfileDTO findById(Long id){
        Optional<UserProfileEntity> userProfile = userProfileRepository.findById(id);
        if(userProfile.isPresent()){
            return  new UserProfileDTO(userProfileRepository.findById(id).orElse(null));
        }
        return null;

    }
}
