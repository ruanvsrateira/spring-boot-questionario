package com.example.springbootquestionario.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
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
