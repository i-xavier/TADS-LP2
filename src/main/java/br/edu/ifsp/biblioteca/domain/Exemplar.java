package br.edu.ifsp.biblioteca.domain;
import java.util.List;

public class Exemplar {
    private Long id;
    private String codigo;
    private EStatusExemplar status;
    private Livro livro;
    private List<Emprestimo> historicoEmprestimo;

    public Exemplar(String codigo, Livro livro){
        this.codigo = codigo;
        this.livro = livro;
        this.status = EStatusExemplar.DISPONIVEL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public EStatusExemplar getStatus(){
        return this.status;
    }

    public void emprestar(){
        if(this.status == EStatusExemplar.EMPRESTADO){
            throw  new IllegalStateException("Exemplar " + this.codigo + " já está emprestado!");
        }

        this.status = EStatusExemplar.EMPRESTADO;
    }

    public void devolver(){
        this.status = EStatusExemplar.DISPONIVEL;
    }

    public boolean estaDisponivel(){
        return this.status == EStatusExemplar.DISPONIVEL;
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", status=" + status +
                '}';
    }
}
