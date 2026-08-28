package br.edu.ifsp.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import br.edu.ifsp.biblioteca.domain.Livro;

public interface ILivroRepository {

    Livro salvar(Livro livro);

    List<Livro> listarTodos();

    Optional<Livro> buscarPorId(Long id);

    Optional<Livro> buscarPorIsbn(String isbn);

    List<Livro> buscarPorTitulo(String titulo);

}
