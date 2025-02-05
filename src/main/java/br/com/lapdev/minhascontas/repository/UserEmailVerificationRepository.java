package br.com.lapdev.minhascontas.repository;

import br.com.lapdev.minhascontas.entity.UserEmailVerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEmailVerificationRepository extends JpaRepository<UserEmailVerificationEntity, Long> {
}
