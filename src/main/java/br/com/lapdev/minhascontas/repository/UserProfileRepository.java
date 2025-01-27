package br.com.lapdev.minhascontas.repository;

import br.com.lapdev.minhascontas.entity.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
}
