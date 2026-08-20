import java.util.List;

class Livro{
    private Long id;
    private String isbn;
    private String titulo;
    private Integer anoPublicacao;

    private List<Autor> autores;
    private List<Exemplar> exemplares;
}