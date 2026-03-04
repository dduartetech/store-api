package diegoduarte.com.store_api.business;

import diegoduarte.com.store_api.business.dto.ProdutoRequestDTO;
import diegoduarte.com.store_api.business.dto.ProdutoResponseDTO;
import diegoduarte.com.store_api.infrastructure.repository.ProdutosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutosService {

    private final ProdutosRepository produtosRepository;

    public ProdutoResponseDTO salvaProduto (ProdutoRequestDTO produtoRequestDTO) {

    }
}
