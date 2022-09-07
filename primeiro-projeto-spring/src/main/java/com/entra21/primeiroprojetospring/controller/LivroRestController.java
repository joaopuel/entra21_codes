package com.entra21.primeiroprojetospring.controller;

import com.entra21.primeiroprojetospring.model.entity.LivroEntity;
import com.entra21.primeiroprojetospring.view.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroRestController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<LivroEntity> getAllLivros(){
        return livroRepository.findAll();
    }
}
