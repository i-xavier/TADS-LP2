package br.edu.ifsp.biblioteca.domain;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private Long id;
    private String isbn;
    private String titulo;
    private Integer anoPublicacao;

    private List<Autor> autores;
    private List<Exemplar> ListaDeExemplares;

    public Livro( String isbn, String titulo, Integer anoPublicacao){
        //this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.ListaDeExemplares = new ArrayList<>();
        this.autores = new ArrayList<>();
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getIsbn(){

        return this.isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public Integer getAnoPublicacao(){
        return this.anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }

    public void adicionarExemplar(Exemplar item){
      this.ListaDeExemplares.add(item);
    }

    public void adicionarAutor(Autor autor){
        this.autores.add(autor);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", autores=" + autores +
                ", exemplares=" + ListaDeExemplares +
                '}';
    }
}
