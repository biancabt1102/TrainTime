package br.com.fiap.traintime.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.traintime.models.Exercicio;

@RestController
public class AvaliacaoController {
    
    Logger log = LoggerFactory.getLogger(AvaliacaoController.class);

    private List<Exercicio> exercicios = new ArrayList<>();

    //Avaliador
    @PostMapping("/traintime/api/{avaliador}/avaliacao")
    public ResponseEntity<Exercicio> create(@PathVariable("avaliador") String avaliador, @RequestBody Exercicio exercicio){
        exercicio.setCargaDoExercicio(0);
        exercicio.setIntervaloDoExercicio(0);
        log.info("Cadastro de Avaliação: " + exercicio);
        exercicio.setIdExercicio(exercicios.size() + 1l);
        exercicios.add(exercicio);

        return ResponseEntity.status(HttpStatus.CREATED).body(exercicio);
    }

    @GetMapping("/traintime/api/avaliacao")
    public List<Exercicio> index(){
        return exercicios;
    }

    @GetMapping("/traintime/api/avaliacao/{id}")
    public ResponseEntity<Exercicio> show(@PathVariable Long id){
        log.info("Buscar avaliação: " + id);
        
        // Encontra a avaliação existente pelo ID informado
        var avaliacaoEncontrada = findAvaliacaoById(id);

        // Retorna NOT FOUND caso não exista avaliação com o ID informado
        if(avaliacaoEncontrada == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(avaliacaoEncontrada);
    }

    // Avaliador
    // Atualiza avaliação de um avaliador para um determinado exercício
    @PutMapping("/traintime/api/{avaliador}/avaliacao/{id}")
    public ResponseEntity<Exercicio> updateAvaliador(@PathVariable Long id, @RequestBody Exercicio exercicio) {
        log.info("Update de avaliação do avaliador: " + id);

        var avaliacaoEncontrada = findAvaliacaoById(id);

        if (avaliacaoEncontrada == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Esses campos não são atualizados na avaliação
        exercicio.setCargaDoExercicio(0);
        exercicio.setIntervaloDoExercicio(0);

        exercicios.remove(avaliacaoEncontrada);
        exercicio.setIdExercicio(id);
        exercicios.add(exercicio);

        return ResponseEntity.ok(exercicio);
    }

    //Aluno
    //Atualiza os dados de um exercício feito por um aluno.
    @PutMapping("/traintime/api/{aluno}/exercicio/{id}")
    public ResponseEntity<Exercicio> updateAluno(@PathVariable("aluno") String aluno, @PathVariable Long id, @RequestBody Exercicio exercicio){
        log.info("Update de avaliação: " + id);

        var avaliacaoEncontrada = findAvaliacaoById(id);

        if(avaliacaoEncontrada == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Atualiza a avaliação com os dados do exercício recebido no request
        avaliacaoEncontrada.setQtdRepeticoes(exercicio.getQtdRepeticoes());
        avaliacaoEncontrada.setQtdSeries(exercicio.getQtdSeries());
        avaliacaoEncontrada.setCargaDoExercicio(exercicio.getCargaDoExercicio());
        avaliacaoEncontrada.setIntervaloDoExercicio(exercicio.getIntervaloDoExercicio());

        return ResponseEntity.ok(avaliacaoEncontrada);
    }


    
    //Avaliador
    @DeleteMapping("/traintime/api/avaliacao/{id}")
    public ResponseEntity<Exercicio> delete(@PathVariable Long id){
        log.info("Delete de avaliação: " + id);

        var avaliacaoEncontrada = findAvaliacaoById(id);
        
        if(avaliacaoEncontrada == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        exercicios.remove(avaliacaoEncontrada);
        return ResponseEntity.noContent().build();
    }

    // Esse método encontra um Exercicio pelo seu ID na lista de exercícios
    private Exercicio findAvaliacaoById(Long id) {
        var avaliacaoEncontrada = exercicios.stream().filter(d -> d.getIdExercicio().equals(id)).findFirst();
        if (avaliacaoEncontrada.isPresent()) {
            return avaliacaoEncontrada.get();
        } else {
            return null;
        }
    }
     
}