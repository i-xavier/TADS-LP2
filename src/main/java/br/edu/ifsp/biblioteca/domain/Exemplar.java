package br.edu.ifsp.biblioteca.domain;
import java.util.List;

public class Exemplar {
    private Long id;
    private String codigo;
    private EStatusExemplar status;
    private Livro livro;
    private List<Emprestimo> historicoEmprestimo;

    public Exemplar(Long id, String codigo, Livro livro){
        this.id = id;
        this.codigo = codigo;
        this.livro = livro;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", status=" + status +
                ", livro=" + livro +
                '}';
    }
}
