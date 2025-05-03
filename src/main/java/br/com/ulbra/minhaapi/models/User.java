package br.com.ulbra.minhaapi.models;

public class User {
    private int id;
    private String nome;
    private String email;

    public User(String nome, String email, int id) {
        this.nome = nome;
        this.email = email;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
