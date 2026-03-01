package diegoduarte.com.store_api.infrastructure.repository;

import diegoduarte.com.store_api.infrastructure.entity.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long> {
}
