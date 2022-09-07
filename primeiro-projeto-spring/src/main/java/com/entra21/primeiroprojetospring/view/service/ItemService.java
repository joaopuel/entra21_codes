package com.entra21.primeiroprojetospring.view.service;

import com.entra21.primeiroprojetospring.model.dto.ItemDTO;
import com.entra21.primeiroprojetospring.model.entity.DvdEntity;
import com.entra21.primeiroprojetospring.view.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTO> getAll() {
        return itemRepository.findAll().stream().map( it -> {
            ItemDTO dto = new ItemDTO();
            dto.setId(it.getId());
            dto.setTitulo(it.getTitulo());
            dto.setEmprestado(it.getEmprestado());
            if(it instanceof DvdEntity){
                dto.setTipo("DVD");
            } else {
                dto.setTipo("Livro");
            }
//            dto.setTipo(it.getClass().getName());
            return dto;
                }).collect(Collectors.toList());
    }
}
