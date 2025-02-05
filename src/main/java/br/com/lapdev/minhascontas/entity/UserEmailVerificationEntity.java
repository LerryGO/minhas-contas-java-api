package br.com.lapdev.minhascontas.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "MC_USER_EMAIL_VERIFICATION")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
public class UserEmailVerificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private Instant expirationDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", unique = true)
    private  UserEntity user;
}
