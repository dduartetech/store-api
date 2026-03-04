package diegoduarte.com.store_api.infrastructure.repository;

import diegoduarte.com.store_api.business.dto.CategoriaResponseDTO;
import diegoduarte.com.store_api.infrastructure.entity.CategoriaEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}
