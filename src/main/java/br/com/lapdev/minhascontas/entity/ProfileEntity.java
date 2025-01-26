package br.com.lapdev.minhascontas.entity;

import br.com.lapdev.minhascontas.dto.ProfileDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "MC_PROFILE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;

    public ProfileEntity(ProfileDTO profile){
        BeanUtils.copyProperties(profile, this);
    }
}
