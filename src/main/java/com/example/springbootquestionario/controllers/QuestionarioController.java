package com.example.springbootquestionario.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionarioController {

    @PostMapping()
    public String responderQuestionario() {


        return "/";
    }
}
