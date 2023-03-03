package br.com.fiap.traintime.models;

public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected int idade;
    protected String telefone;
    protected String matricula;
    protected String nomeDaAcademia;

    public Pessoa(){

    } 

    public Pessoa(String nome, String email, int idade, String telefone, String matricula, String nomeDaAcademia) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
        this.matricula = matricula;
        this.nomeDaAcademia = nomeDaAcademia;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getEmail(){
        return email;
    }

    public String getTelefone(){
        return telefone;
    }

    public String getMatricula(){
        return matricula;
    }

    public String getNomeDaAcademia() {
        return nomeDaAcademia;
    }

    public void setNomeDaAcademia(String nomeDaAcademia) {
        this.nomeDaAcademia = nomeDaAcademia;
    }

    @Override
    public String toString(){
        return "Pessoa [Nome: " + nome + "\n Idade:" + idade + "\n Email=" + email + "\n Telefone" + telefone + "\n Matricula=" +
        matricula + "]";
    }

}