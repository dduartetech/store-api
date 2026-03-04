package diegoduarte.com.store_api.business;

import diegoduarte.com.store_api.business.converter.StoreConverter;
import diegoduarte.com.store_api.business.dto.CategoriaRequestDTO;
import diegoduarte.com.store_api.business.dto.CategoriaResponseDTO;
import diegoduarte.com.store_api.infrastructure.entity.CategoriaEntity;
import diegoduarte.com.store_api.infrastructure.exceptions.ResourceNotFoundException;
import diegoduarte.com.store_api.infrastructure.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final StoreConverter storeConverter;

    public CategoriaResponseDTO criaCategoria (CategoriaRequestDTO categoriaRequestDTO) {

        CategoriaEntity entity = storeConverter.paraCategoriaEntity(categoriaRequestDTO);
        return storeConverter.paraCategoriaDTO(categoriaRepository.save(entity));

    }

    public CategoriaResponseDTO buscarPorId (Long id) {

        return storeConverter.paraCategoriaDTO(categoriaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Categoria não encontrada")));
    }

    public List<CategoriaResponseDTO> listaCategorias () {

        List<CategoriaEntity> categorias = categoriaRepository.findAll();
        List<CategoriaResponseDTO> categoriasDTO = new ArrayList<>();

        for (CategoriaEntity categoria : categorias) {
            categoriasDTO.add(storeConverter.paraCategoriaDTO(categoria));
        }

        return categoriasDTO;
    }

    public CategoriaResponseDTO atualizaCategoria (CategoriaRequestDTO categoriaRequestDTO, Long id) {
        CategoriaEntity entity = categoriaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Categoria não encontrada"));

        entity.setNome(categoriaRequestDTO.getNome());
        CategoriaEntity salvo = storeConverter.updateCategoria(categoriaRequestDTO, entity);

        return storeConverter.paraCategoriaDTO(categoriaRepository.save(salvo));
    }

    public void deletaPorId (Long id) {
        categoriaRepository.deleteById(id);
    }
}
