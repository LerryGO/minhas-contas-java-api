package br.com.lapdev.minhascontas.dto;

import br.com.lapdev.minhascontas.entity.UserProfileEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.beans.BeanProperty;

@Getter
@Setter
@NoArgsConstructor
public class UserProfileDTO {

    private Long id;
    private UserDTO user;
    private ProfileDTO profile;

    public UserProfileDTO(UserProfileEntity userProfile){
        BeanUtils.copyProperties(userProfile, this);
        if(userProfile.getUser() != null){
            this.user = new UserDTO(userProfile.getUser());
        }
        if(userProfile.getProfile() != null){
            this.profile = new ProfileDTO(userProfile.getProfile());
        }
    }
}
