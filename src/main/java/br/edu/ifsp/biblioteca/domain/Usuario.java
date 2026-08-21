package br.edu.ifsp.biblioteca.domain;
import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private String email;

    private List<Emprestimo> emprestimo;

    public Usuario(Long id, String nome, String email){
        this.id = id;
        this.email = email;
        this.nome = nome;
    }

    public String getEmail(){

        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
