package com.example.springbootquestionario.repositories;

import com.example.springbootquestionario.entities.Questao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface QuestaoRepository extends CrudRepository<Questao, Integer> {
    @Query(value="SELECT COUNT(q.id) FROM questao q; ", nativeQuery = true)
    String countQuestoes();
}
