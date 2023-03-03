package br.com.fiap.traintime.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.traintime.enuns.CategoriaDeExercicio;
import br.com.fiap.traintime.enuns.DiaDaSemana;
import br.com.fiap.traintime.models.Exercicio;

@RestController
public class AvaliacaoController {

    @GetMapping("/traintime/api/exercicio")
    public Exercicio show(){
        return new Exercicio(
            "leg Press",
            15,
            3,
            CategoriaDeExercicio.CARDIOVASCULAR,
            DiaDaSemana.SEGUNDA_FEIRA,
            20,
            15
        );
    }
}