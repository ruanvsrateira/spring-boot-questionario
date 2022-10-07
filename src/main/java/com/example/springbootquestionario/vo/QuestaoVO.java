package com.example.springbootquestionario.vo;

import lombok.Getter;
import lombok.Setter;

public class QuestaoVO {
    private String titulo;

    private String alternativa1;
    private Boolean alternativa1Correta;

    private String alternativa2;
    private Boolean alternativa2Correta;

    private String alternativa3;
    private Boolean alternativa3Correta;

    private String alternativa4;
    private Boolean alternativa4Correta;

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    private Integer pontos;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public Boolean getAlternativa1Correta() {
        return alternativa1Correta;
    }

    public void setAlternativa1Correta(Boolean alternativa1Correta) {
        this.alternativa1Correta = alternativa1Correta;
    }

    public String getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public Boolean getAlternativa2Correta() {
        return alternativa2Correta;
    }

    public void setAlternativa2Correta(Boolean alternativa2Correta) {
        this.alternativa2Correta = alternativa2Correta;
    }

    public String getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public Boolean getAlternativa3Correta() {
        return alternativa3Correta;
    }

    public void setAlternativa3Correta(Boolean alternativa3Correta) {
        this.alternativa3Correta = alternativa3Correta;
    }

    public String getAlternativa4() {
        return alternativa4;
    }

    public void setAlternativa4(String alternativa4) {
        this.alternativa4 = alternativa4;
    }

    public Boolean getAlternativa4Correta() {
        return alternativa4Correta;
    }

    public void setAlternativa4Correta(Boolean alternativa4Correta) {
        this.alternativa4Correta = alternativa4Correta;
    }
}
