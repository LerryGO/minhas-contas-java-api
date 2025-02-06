package br.com.lapdev.minhascontas.service;

import br.com.lapdev.minhascontas.dto.UserDTO;
import br.com.lapdev.minhascontas.entity.UserEmailVerificationEntity;
import br.com.lapdev.minhascontas.entity.UserEntity;
import br.com.lapdev.minhascontas.entity.enums.UserSituationType;
import br.com.lapdev.minhascontas.repository.UserEmailVerificationRepository;
import br.com.lapdev.minhascontas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Autowired
    UserEmailVerificationRepository userEmailVerificationRepository;

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

        UserEmailVerificationEntity verificationEntity = new UserEmailVerificationEntity();
        verificationEntity.setUser(userEntity);
        verificationEntity.setUuid(UUID.randomUUID());
        verificationEntity.setExpirationDate(Instant.now().plusMillis(900000));
        userEmailVerificationRepository.save(verificationEntity);


        emailService.sendTextEmail(user.getEmail(), "Novo usuário cadastrado", "Você está recebendo um email de cadastro, o número para validação é "+ verificationEntity.getUuid());
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

    public String checkRegistration(String uuid){

       Optional<UserEmailVerificationEntity> userEmailVerificationEntity = userEmailVerificationRepository.findByUuid(UUID.fromString(uuid));
       if(userEmailVerificationEntity.isPresent()){
           UserEmailVerificationEntity user = userEmailVerificationEntity.get();
           if((user.getExpirationDate().compareTo(Instant.now()) >= 0)){
                UserEntity userEntity = user.getUser();
                userEntity.setSituation(UserSituationType.ACTIVE);

                userRepository.save(userEntity);

                return "Usuário verificado";
           }
       }else{
           userEmailVerificationEntity.ifPresent(userEmailVerificationRepository::delete);
           return  "Usuário não verificado";
       }
        return null;
    }


}
