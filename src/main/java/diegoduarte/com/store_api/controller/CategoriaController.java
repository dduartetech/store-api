package diegoduarte.com.store_api.controller;

import diegoduarte.com.store_api.business.CategoriaService;
import diegoduarte.com.store_api.business.dto.CategoriaRequestDTO;
import diegoduarte.com.store_api.business.dto.CategoriaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
@Tag(name = "Categoria", description = "Controle de categorias (cria, lista, atualiza)")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    @Operation(summary = "Salva Categoria", description = "Salva uma nova categoria")
    @ApiResponse(responseCode = "200", description = "Categoria salva com sucesso!")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<CategoriaResponseDTO> criaCategoria(@RequestBody CategoriaRequestDTO dto) {
        return ResponseEntity.ok(categoriaService.criaCategoria(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca Categoria por Id", description = "Busca categoria especifica por id")
    @ApiResponse(responseCode = "200", description = "Categoria localizada com sucesso!")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Lista Todas Categorias Cadastradas", description = "Retorna uma lista de categorias cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<CategoriaResponseDTO>> listaCategorias() {
        return ResponseEntity.ok(categoriaService.listaCategorias());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza Categoria por Id", description = "Atualiza nome de Categoria")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<CategoriaResponseDTO> atualizaCategoria(@RequestBody CategoriaRequestDTO dto,
                                                                  @PathVariable("id") Long id) {
        return ResponseEntity.ok(categoriaService.atualizaCategoria(dto, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta Categoria por Id", description = "Deleta categoria por id")
    @ApiResponse(responseCode = "200", description = "Categoria deletada com sucesso!")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaCategoria(@PathVariable("id") Long id) {
        categoriaService.deletaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
