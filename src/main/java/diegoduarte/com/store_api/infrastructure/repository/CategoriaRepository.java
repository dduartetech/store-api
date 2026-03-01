package diegoduarte.com.store_api.infrastructure.repository;

import diegoduarte.com.store_api.infrastructure.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
