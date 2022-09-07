package com.entra21.primeiroprojetospring.controller;

import com.entra21.primeiroprojetospring.model.dto.GeneroDTO;
import com.entra21.primeiroprojetospring.model.dto.GeneroPayLoadDTO;
import com.entra21.primeiroprojetospring.view.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroRestController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<GeneroDTO> getGeneros() {
        return generoService.getAll();
    }

    @PostMapping
    public void addGenero(@RequestBody GeneroPayLoadDTO dto) {
        generoService.saveGenero(dto);
    }

    @GetMapping("/{id}")
    public GeneroDTO getGenero(@PathVariable(name = "id") Long id) {
        return generoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGenero(@PathVariable(name = "id") Long id) {
        generoService.delete(id);
    }

    @PutMapping("/{id}")
    public GeneroDTO updateGenero(@PathVariable(name = "id") Long id,
                                      @RequestBody String novoNome) {
        return generoService.update(id, novoNome);
    }
}
