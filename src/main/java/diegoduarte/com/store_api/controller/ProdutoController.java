package diegoduarte.com.store_api.controller;

import diegoduarte.com.store_api.business.ProdutosService;
import diegoduarte.com.store_api.business.dto.CategoriaRequestDTO;
import diegoduarte.com.store_api.business.dto.CategoriaResponseDTO;
import diegoduarte.com.store_api.business.dto.ProdutoRequestDTO;
import diegoduarte.com.store_api.business.dto.ProdutoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
@Tag(name = "Produtos", description = "Controle de produtos (cadastra, lista, atualiza)")
public class ProdutoController {

    private final ProdutosService produtosService;

    @PostMapping
    @Operation(summary = "Cadastra Produto", description = "Cadastra um novo produto")
    @ApiResponse(responseCode = "200", description = "Produto cadastrado com sucesso!")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ProdutoResponseDTO> salvaProduto(@RequestBody ProdutoRequestDTO dto) {
        return ResponseEntity.ok(produtosService.salvaProduto(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca Produto por Id", description = "Busca produto especifico por id")
    @ApiResponse(responseCode = "200", description = "Produto localizado com sucesso!")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(produtosService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Lista Todos Produtos Cadastrados", description = "Retorna uma lista de produtos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        return ResponseEntity.ok(produtosService.listarProdutos());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza Produto por Id", description = "Atualiza dados de Produto")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@RequestBody ProdutoRequestDTO dto,
                                                                  @PathVariable("id") Long id) {
        return ResponseEntity.ok(produtosService.atualizarProduto(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta Produto por Id", description = "Deleta produto por id")
    @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso!")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaCategoria(@PathVariable("id") Long id) {
        produtosService.deletaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
