package br.com.lapdev.minhascontas.repository;

import br.com.lapdev.minhascontas.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository< ResourceEntity,Long> {
}
