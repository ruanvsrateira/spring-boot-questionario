package com.example.springbootquestionario.services;

import com.example.springbootquestionario.entities.Alternativa;
import com.example.springbootquestionario.repositories.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AlternativaService {

    @Autowired
    AlternativaRepository repo;

    @Transactional
    public Alternativa criarNovaAlternativa(String titulo, Boolean correta) {
        Alternativa alternativa = new Alternativa();
        alternativa.setTitulo(titulo);
        alternativa.setCorreta(correta);
        return repo.save(alternativa);
    }

}
