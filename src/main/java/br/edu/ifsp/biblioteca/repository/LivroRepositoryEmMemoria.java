package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Livro;

import java.util.*;

public class LivroRepositoryEmMemoria implements ILivroRepository {

    private final Map<Long, Livro> livros = new HashMap<Long, Livro>();
    private Long sequenciaId = 0l;

    @Override
    public Livro salvar(Livro livro) {

        if(livro.getId() == null) {
            this.sequenciaId = this.sequenciaId + 1;
            livro.setId(this.sequenciaId);
        }

        this.livros.put(livro.getId(), livro);

        return livro;
    }

    @Override
    public List<Livro> listarTodos() {

        return new ArrayList<>(this.livros.values());

    }

    @Override
    public Optional<Livro> buscarPorId(Long id) {

        return Optional.ofNullable(this.livros.get(id));

       /*Livro l = this.livros.get(id);

       if(l == null){
           return Optional.empty();
       }

        return Optional.of(l);*/


    }

    @Override
    public Optional<Livro> buscarPorIsbn(String isbn) {

        //Collection<Livro> colecaoLivros = this.livros.values();
        if (isbn == null) {
            return Optional.empty();
        }

       for (Livro livro : this.livros.values()) {
           if(isbn.equals(livro.getIsbn())){
               return Optional.of(livro);
           }
       }

        return Optional.empty();
    }

    @Override
    public List<Livro> buscarPorTitulo(String titulo) {

        if(titulo == null) {
            return null;
        }

        List<Livro> livrosEncontrados = new ArrayList<>();

        for (Livro livro : this.livros.values()) {
            if(livro.getTitulo().contains(titulo)){
                livrosEncontrados.add(livro);
            }
        }

        return livrosEncontrados;
    }
}
