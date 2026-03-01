package diegoduarte.com.store_api.business.dto;

import diegoduarte.com.store_api.infrastructure.entity.CategoriaEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoRequestDTO {

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Long categoriaId;

}
