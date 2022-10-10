package com.example.springbootquestionario.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questao;
    private Integer pontos;
    @OneToMany
    @JoinColumn(name="questao_id")
    private List<Alternativa> alternativas;
}
