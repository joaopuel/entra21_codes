package com.entra21.primeiroprojetospring.model.dto;

import com.entra21.primeiroprojetospring.model.entity.ItemEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
@Data
public class AvaliacaoDTO {
    private Long id;
    private String nomeAvaliador;
    private Double nota;
    private String comentario;
}
