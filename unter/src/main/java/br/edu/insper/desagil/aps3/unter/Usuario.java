package br.edu.insper.desagil.aps3.unter;

public class Usuario {
    private String cpf;
    private String nome;

    public Usuario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void avalia(Corrida corrida, int nota) {
    }
}
