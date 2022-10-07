package com.example.springbootquestionario.services;

import com.example.springbootquestionario.entities.Alternativa;
import com.example.springbootquestionario.entities.Questao;
import com.example.springbootquestionario.repositories.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class QuestaoService {

    @Autowired
    QuestaoRepository repo;

    @Transactional
    public Iterable<Questao> listarQuestoes() {
        return repo.findAll();
    }

    @Transactional
    public String countQuestoes() {
        return repo.countQuestoes();
    }

    @Transactional
    public Questao criarNovaQuestao(String titulo, Integer pontos, ArrayList<Alternativa> alternativas) {
        Questao questao = new Questao();
        questao.setQuestao(titulo);
        questao.setAlternativas(alternativas);
        questao.setPontos(pontos);

        return repo.save(questao);
    }

}
