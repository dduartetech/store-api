package diegoduarte.com.store_api.business;

import diegoduarte.com.store_api.business.converter.StoreConverter;
import diegoduarte.com.store_api.business.dto.ProdutoRequestDTO;
import diegoduarte.com.store_api.business.dto.ProdutoResponseDTO;
import diegoduarte.com.store_api.infrastructure.entity.CategoriaEntity;
import diegoduarte.com.store_api.infrastructure.entity.ProdutosEntity;
import diegoduarte.com.store_api.infrastructure.exceptions.ResourceNotFoundException;
import diegoduarte.com.store_api.infrastructure.repository.CategoriaRepository;
import diegoduarte.com.store_api.infrastructure.repository.ProdutosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutosService {

    private final ProdutosRepository produtosRepository;
    private final CategoriaRepository categoriaRepository;
    private final StoreConverter storeConverter;

    public ProdutoResponseDTO salvaProduto(ProdutoRequestDTO produtoRequestDTO) {

        CategoriaEntity categoria = categoriaRepository.findById(produtoRequestDTO.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        ProdutosEntity entity = storeConverter.paraProdutoEntity(produtoRequestDTO);
        entity.setCategoria(categoria);

        return storeConverter.paraProdutoDTO(produtosRepository.save(entity));
    }

    public ProdutoResponseDTO buscarPorId (Long id) {

        return storeConverter.paraProdutoDTO(produtosRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Produto não encontrado")));
    }

    public List<ProdutoResponseDTO> listarProdutos () {

        List<ProdutosEntity> entities = produtosRepository.findAll();
        List<ProdutoResponseDTO> dtos = new ArrayList<>();

        for (ProdutosEntity entity : entities) {
            dtos.add(storeConverter.paraProdutoDTO(entity));
        }

        return dtos;
    }

    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO dto) {

        ProdutosEntity entity = produtosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        if (dto.getNome() != null) {
            entity.setNome(dto.getNome());
        }

        if (dto.getDescricao() != null) {
            entity.setDescricao(dto.getDescricao());
        }

        if (dto.getPreco() != null) {
            entity.setPreco(dto.getPreco());
        }

        if (dto.getCategoriaId() != null) {
            CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoriaId())
                    .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

            entity.setCategoria(categoria);
        }

        return storeConverter.paraProdutoDTO(produtosRepository.save(entity));
    }

    public void deletaPorId (Long id) {
        produtosRepository.deleteById(id);
    }


}
