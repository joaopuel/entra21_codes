package com.entra21.primeiroprojetospring.model.dto;

import com.entra21.primeiroprojetospring.model.entity.AvaliacaoEntity;
import com.entra21.primeiroprojetospring.model.entity.FranquiaEntity;
import com.entra21.primeiroprojetospring.model.entity.GeneroEntity;
import lombok.Data;
import java.util.Set;

@Data
public class ItemDTO {
    private Long id;
    private String titulo;
//    private Double valorVenda;
//    private Double valorLocacao;
    private Boolean emprestado;
//    private FranquiaEntity franquia;
    private Set<AvaliacaoDTO> avaliacoes;
//    private Set<GeneroEntity> generos;
    private String tipo;
}
