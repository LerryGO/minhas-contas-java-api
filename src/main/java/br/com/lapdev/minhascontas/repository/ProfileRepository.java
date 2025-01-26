package br.com.lapdev.minhascontas.repository;

import br.com.lapdev.minhascontas.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
}
