package br.edu.ifsp.biblioteca.domain;

import java.time.LocalDate;

public class Emprestimo {
    private Long id;
    //private LocalDate dataEmprestimo;
    //private LocalDate dataPrevisaoDevolucao;
    //private LocalDate dataDevolucao;

    private Usuario usuario;

    private Exemplar Exemplar;

    public Emprestimo(Long id){
        this.id = id;
    }


}
