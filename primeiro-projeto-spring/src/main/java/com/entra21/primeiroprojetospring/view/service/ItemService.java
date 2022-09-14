package com.entra21.primeiroprojetospring.view.service;

import com.entra21.primeiroprojetospring.model.dto.AvaliacaoDTO;
import com.entra21.primeiroprojetospring.model.dto.ItemDTO;
import com.entra21.primeiroprojetospring.model.entity.DvdEntity;
import com.entra21.primeiroprojetospring.model.entity.ItemEntity;
import com.entra21.primeiroprojetospring.view.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTO> getAll(Long idGenero) {
        List<ItemEntity> list;
        if(idGenero != null){
            list = itemRepository.findAllByAvaliacoes_Id(idGenero);
        } else {
            list = itemRepository.findAll();
        }
        return list.stream().map( it -> {
            ItemDTO dto = new ItemDTO();
            dto.setId(it.getId());
            dto.setTitulo(it.getTitulo());
            dto.setEmprestado(it.getEmprestado());
            dto.setTipo(it.getType());
            dto.setAvaliacoes(it.getAvaliacoes().stream().map(av -> {
                AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
                avaliacaoDTO.setId(av.getId());
                avaliacaoDTO.setComentario(av.getComentario());
                avaliacaoDTO.setNomeAvaliador(av.getNomeAvaliador());
                avaliacaoDTO.setNota(av.getNota());
                return avaliacaoDTO;
            }).collect(Collectors.toSet()));
            return dto;
                }).collect(Collectors.toList());
    }
}
