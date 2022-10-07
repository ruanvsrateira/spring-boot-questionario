package com.example.springbootquestionario.repositories;

import com.example.springbootquestionario.entities.Alternativa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface AlternativaRepository extends CrudRepository<Alternativa, Integer> {
}
