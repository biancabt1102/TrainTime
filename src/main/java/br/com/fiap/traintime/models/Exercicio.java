package br.com.fiap.traintime.models;

import br.com.fiap.traintime.enuns.CategoriaDeExercicio;
import br.com.fiap.traintime.enuns.DiaDaSemana;

public class Exercicio {
    private String nomeDoExercicio;
    private int qtdRepeticoes;
    private int qtdSeries;
    private CategoriaDeExercicio categoriaId;
    private DiaDaSemana diaDaSemanaId;
    private int cargaDoExercicio;
    private int intervaloDoExercicio;

    public Exercicio(){

    }

    public Exercicio(String nomeDoExercicio, int qtdRepeticoes, int qtdSeries, CategoriaDeExercicio categoriaId,
            DiaDaSemana diaDaSemanaId, int cargaDoExercicio, int intervaloDoExercicio) {
            this.nomeDoExercicio = nomeDoExercicio;
            this.qtdRepeticoes = qtdRepeticoes;
            this.qtdSeries = qtdSeries;
            this.categoriaId = categoriaId;
            this.diaDaSemanaId = diaDaSemanaId;
            this.cargaDoExercicio = cargaDoExercicio;
            this.intervaloDoExercicio = intervaloDoExercicio;
    }

    public String getNomeDoExercicio() {
        return nomeDoExercicio;
    }

    public void setNomeDoExercicio(String nomeDoExercicio) {
        this.nomeDoExercicio = nomeDoExercicio;
    }

    public int getQtdRepeticoes() {
        return qtdRepeticoes;
    }

    public void setQtdRepeticoes(int qtdRepeticoes) {
        this.qtdRepeticoes = qtdRepeticoes;
    }

    public int getQtdSeries() {
        return qtdSeries;
    }

    public void setQtdSeries(int qtdSeries) {
        this.qtdSeries = qtdSeries;
    }

    public CategoriaDeExercicio getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(CategoriaDeExercicio categoriaId) {
        this.categoriaId = categoriaId;
    }

    public DiaDaSemana getDiaDaSemanaId() {
        return diaDaSemanaId;
    }

    public void setDiaDaSemanaId(DiaDaSemana diaDaSemanaId) {
        this.diaDaSemanaId = diaDaSemanaId;
    }

    public int getCargaDoExercicio() {
        return cargaDoExercicio;
    }

    public void setCargaDoExercicio(int cargaDoExercicio) {
        this.cargaDoExercicio = cargaDoExercicio;
    }

    public int getIntervaloDoExercicio() {
        return intervaloDoExercicio;
    }

    public void setIntervaloDoExercicio(int intervaloDoExercicio) {
        this.intervaloDoExercicio = intervaloDoExercicio;
    }
}