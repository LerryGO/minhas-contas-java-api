package br.com.lapdev.minhascontas.repository;

import br.com.lapdev.minhascontas.entity.UserEmailVerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserEmailVerificationRepository extends JpaRepository<UserEmailVerificationEntity, Long> {

    public Optional<UserEmailVerificationEntity> findByUuid(UUID uuid);

}
