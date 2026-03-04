package diegoduarte.com.store_api.business.converter;

import diegoduarte.com.store_api.business.dto.CategoriaRequestDTO;
import diegoduarte.com.store_api.business.dto.CategoriaResponseDTO;
import diegoduarte.com.store_api.business.dto.ProdutoRequestDTO;
import diegoduarte.com.store_api.business.dto.ProdutoResponseDTO;
import diegoduarte.com.store_api.infrastructure.entity.CategoriaEntity;
import diegoduarte.com.store_api.infrastructure.entity.ProdutosEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreConverter {

    public ProdutosEntity paraProdutoEntity (ProdutoRequestDTO requestDTO) {
        return ProdutosEntity.builder()
                .preco(requestDTO.getPreco())
                .descricao(requestDTO.getDescricao())
                .nome(requestDTO.getNome())
                .build();
    }

    public ProdutoResponseDTO paraProdutoDTO (ProdutosEntity entity) {
        return ProdutoResponseDTO.builder()
                .id(entity.getId())
                .preco(entity.getPreco())
                .categoria(entity.getCategoria().getNome())
                .descricao(entity.getDescricao())
                .nome(entity.getNome())
                .build();
    }

    public CategoriaEntity paraCategoriaEntity (CategoriaRequestDTO requestDTO) {
        return CategoriaEntity.builder()
                .nome(requestDTO.getNome())
                .build();
    }

    public CategoriaResponseDTO paraCategoriaDTO (CategoriaEntity entity) {
        return CategoriaResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build();
    }


}
