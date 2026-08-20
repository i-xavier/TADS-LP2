import java.time.LocalDate;

class Emprestimo{
    private Long id;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevisaoDevolucao;
    private LocalDate dataDevolucao;

    private Usuario usuario;

    private Exemplar exemplar;
}