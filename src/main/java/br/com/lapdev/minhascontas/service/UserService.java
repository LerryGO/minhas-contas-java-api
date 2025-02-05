package br.com.lapdev.minhascontas.service;

import br.com.lapdev.minhascontas.dto.UserDTO;
import br.com.lapdev.minhascontas.entity.UserEntity;
import br.com.lapdev.minhascontas.entity.enums.UserSituationType;
import br.com.lapdev.minhascontas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public List<UserDTO> getAll(){
        List<UserEntity> users = userRepository.findAll();
        return  users.stream().map(UserDTO::new).toList();
    }

    public void insert(UserDTO user){
        UserEntity userEntity = new UserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userEntity);
    }

    public void registerUser(UserDTO user){
        UserEntity userEntity = new UserEntity(user);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setSituation(UserSituationType.PENDING);
        userEntity.setId(null);

        emailService.sendTextEmail(user.getEmail(), "Novo usuário cadastrado", "Você está recebendo um email de cadastro");
        userRepository.save(userEntity);
    }

    public UserDTO update(UserDTO user){
        UserEntity userEntity = new UserEntity(user);
        return new UserDTO(userRepository.save(userEntity));
    }

    public void delete(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        user.ifPresent(userEntity -> userRepository.delete(userEntity));
    }

    public UserDTO findById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
       if(user.isPresent()){
           return  new UserDTO(userRepository.findById(id).orElse(null));
       }
       return null;

    }

}
