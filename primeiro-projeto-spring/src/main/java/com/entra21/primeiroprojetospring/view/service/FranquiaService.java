package com.entra21.primeiroprojetospring.view.service;

import com.entra21.primeiroprojetospring.model.dto.FranquiaPayLoadDTO;
import com.entra21.primeiroprojetospring.model.entity.FranquiaEntity;
import com.entra21.primeiroprojetospring.model.dto.FranquiaDTO;
import com.entra21.primeiroprojetospring.view.repository.FranquiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FranquiaService {

    @Autowired
    private FranquiaRepository franquiaRepository;

    public List<FranquiaDTO> getAll() {
        return franquiaRepository.findAll().stream().map(fr -> {
            FranquiaDTO dto = new FranquiaDTO();
            dto.setId(fr.getId());
            dto.setNome(fr.getNome());
            return dto;
        }).collect(Collectors.toList());

//        List<FranquiaEntity> flist = franquiaRepository.findAll();
//        List<FranquiaListagemDTO> fdtolist = new ArrayList<>();
    }

    public void saveFranquia(FranquiaPayLoadDTO dto){
        FranquiaEntity entity = new FranquiaEntity();
        entity.setNome(dto.getNome());
        franquiaRepository.save(entity);
    }

    public FranquiaDTO getById(Long id) {
        FranquiaEntity franquia = franquiaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Franquia não encontrada!"));
        FranquiaDTO dto = new FranquiaDTO();
        dto.setId(franquia.getId());
        dto.setNome(franquia.getNome());
        return dto;
    }

    public void delete(Long id) {
        franquiaRepository.deleteById(id);
    }

    public FranquiaDTO update(Long id, String novoNome) {
        FranquiaEntity e = franquiaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Franquia não encontrada!"));
        e.setNome(novoNome);
        e = franquiaRepository.save(e);
        FranquiaDTO dto = new FranquiaDTO();
        dto.setNome(e.getNome());
        dto.setId(e.getId());
        return dto;
    }
}
