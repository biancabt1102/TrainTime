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

    @PostMapping("/traintime/api/{avaliador}/avaliacao")
    public ResponseEntity<Exercicio> create(@PathVariable("avaliador") String avaliador, @RequestBody Exercicio exercicio){
        log.info("Cadastro de Avaliação: " + exercicio);
        exercicio.setIdExercicio(exercicios.size() + 1l);
        exercicios.add(exercicio);

        return ResponseEntity.status(HttpStatus.CREATED).body(exercicio);
    }

    @GetMapping("/traintime/api/avaliacao")
    public List<Exercicio> index(){
        return exercicios;
    }

    //avaliador
    @GetMapping("/traintime/api/avaliacao/{id}")
    public ResponseEntity<Exercicio> show(@PathVariable Long id){
        log.info("Buscar avaliação: " + id);
        
        var avaliacaoEncontrada = findAvaliacaoById(id);

        if(avaliacaoEncontrada == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(avaliacaoEncontrada);
    }

    //avaliador
    @PutMapping("/traintime/api/avaliacao/{id}")
    public ResponseEntity<Exercicio> update(@PathVariable Long id, @RequestBody Exercicio exercicio){
        log.info("Update de avaliação: " + id);

        var avaliacaoEncontrada = findAvaliacaoById(id);

        if(avaliacaoEncontrada == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        exercicios.remove(avaliacaoEncontrada);
        exercicio.setIdExercicio(id);
        exercicios.add(exercicio);

        return ResponseEntity.ok(exercicio);
    }
    
    //avaliador
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

    private Exercicio findAvaliacaoById(Long id) {
        var avaliacaoEncontrada = exercicios.stream().filter(d -> d.getIdExercicio().equals(id)).findFirst();
        if (avaliacaoEncontrada.isPresent()) {
            return avaliacaoEncontrada.get();
        } else {
            return null;
        }
    }
     
}