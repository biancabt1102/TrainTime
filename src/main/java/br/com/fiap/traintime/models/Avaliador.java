package br.com.fiap.traintime.models;

public class Avaliador extends Pessoa{
    private String login;
    private String senha;

    public Avaliador() {

    }

    public Avaliador(String nome, String email, int idade, String telefone, String matricula, String nomeDaAcademia,
            String senha, String login) {
        super(nome, email, idade, telefone, matricula, nomeDaAcademia);
        this.senha = senha;
        this.login = login;
    } 

    /* Getters e Setters */

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /* Métodos */

    public void cadastroSenha(String senha){
        this.senha = "AV" + senha;
    }

    public boolean verificarSenha(String senha){
        if(this.senha.equals(senha)){
            System.out.println("Senha correta!");
            return true;
        } else {
            System.err.println("Senha incorreta! Digite novamente");
            return false;
        }
    }

    public boolean verificarLogin(String email){
        if(this.email.equals(email)){
            System.out.println("Email digitado corretamente");
            return true;
        } else{
            System.err.println("Email incorreto! Digite novamente");
            return false;
        }
    }


}