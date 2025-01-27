package br.com.lapdev.minhascontas.entity;

import br.com.lapdev.minhascontas.dto.ProfileDTO;
import br.com.lapdev.minhascontas.dto.UserDTO;
import br.com.lapdev.minhascontas.dto.UserProfileDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "MC_USER_PROFILE")
@Getter
@Setter
@NoArgsConstructor
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private ProfileEntity profile;

    public UserProfileEntity(UserProfileDTO userProfile){
        BeanUtils.copyProperties(userProfile, this);
        if(userProfile.getUser() != null){
            this.user = new UserEntity(userProfile.getUser());
        }
        if(userProfile.getProfile() != null){
            this.profile = new ProfileEntity(userProfile.getProfile());
        }
    }
}
