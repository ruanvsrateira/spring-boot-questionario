package com.example.springbootquestionario.services;

import com.example.springbootquestionario.entities.Alternativa;
import com.example.springbootquestionario.entities.Questao;
import com.example.springbootquestionario.repositories.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestaoService {

    @Autowired
    QuestaoRepository repo;

    @Transactional
    public Questao criarNovaQuestao(String titulo, Integer pontos, ArrayList<Alternativa> alternativas) {
        Questao questao = new Questao();
        questao.setQuestao(titulo);
        questao.setAlternativas(alternativas);
        questao.setPontos(pontos);

        return repo.save(questao);
    }

    public List<Questao> listarQuestoes() {
        Iterable<Questao> iterableQuestoes = repo.findAll();
        List<Questao> listaQuestoes = new ArrayList<Questao>();
        iterableQuestoes.forEach(questao -> listaQuestoes.add(questao));

        return listaQuestoes;
    }

    public String countQuestoes() {
        return repo.countQuestoes();
    }

    public Optional<Questao> findQuestaoById(Integer id) {
        return repo.findById(id);
    }

}
