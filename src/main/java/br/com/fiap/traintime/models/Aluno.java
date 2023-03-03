package br.com.fiap.traintime.models;

public class Aluno extends Pessoa{
    private String senha;
    private String login;

    public Aluno(){

    }

    public Aluno(String nome, String email, int idade, String telefone, String matricula, String nomeDaAcademia,
            String senha, String login) {
        super(nome, email, idade, telefone, matricula, nomeDaAcademia);
        this.senha = senha;
        this.login = login;
    }

    /* Getters e Setters */

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    /* Métodos */

    public void cadastroSenha(String senha){
        this.senha = "AL" + senha;
    }

    public void verificarSenha(String senha){
        if(this.senha.equals(senha)){
            System.out.println("Senha correta!");
        } else {
            System.err.println("Senha incorreta! Digite novamente");
        }
    }

}