package com.example.springbootquestionario.controllers;

import com.example.springbootquestionario.entities.Alternativa;
import com.example.springbootquestionario.services.AlternativaService;
import com.example.springbootquestionario.services.QuestaoService;
import com.example.springbootquestionario.vo.QuestaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;

@Controller
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @Autowired
    private AlternativaService alternativaService;

    @GetMapping("/questionario")
    public String listarQuestões(@ModelAttribute("usuarioId") Integer id, Model model) {
        model.addAttribute("usuarioId", id);
        model.addAttribute("questao", questaoService.listarQuestoes());
        model.addAttribute("quantidadeQuestoes", questaoService.countQuestoes());

        return "questionario";
    }

    @GetMapping("/cadastrar-questao")
    public String cadastrarQuestao(QuestaoVO questaoVO, Model model) {
        model.addAttribute("questao", questaoVO);

        return "cad_questao";
    }

    @PostMapping("/cadastrar-questao")
    public String salvarQuestao(QuestaoVO questaoVO) {
        Alternativa alternativa1 = alternativaService.criarNovaAlternativa(questaoVO.getAlternativa1(), questaoVO.getAlternativa1Correta());
        Alternativa alternativa2 = alternativaService.criarNovaAlternativa(questaoVO.getAlternativa2(), questaoVO.getAlternativa2Correta());
        Alternativa alternativa3 = alternativaService.criarNovaAlternativa(questaoVO.getAlternativa3(), questaoVO.getAlternativa3Correta());
        Alternativa alternativa4 = alternativaService.criarNovaAlternativa(questaoVO.getAlternativa4(), questaoVO.getAlternativa4Correta());

        ArrayList<Alternativa> alternativas = new ArrayList<Alternativa>();
        alternativas.add(alternativa1);
        alternativas.add(alternativa2);
        alternativas.add(alternativa3);
        alternativas.add(alternativa4);

        questaoService.criarNovaQuestao(questaoVO.getTitulo(), questaoVO.getPontos(), alternativas);

        return "redirect:/cadastrar-questao";
    }

}
