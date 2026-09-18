package br.edu.ifsp.biblioteca.cli;

import br.edu.ifsp.biblioteca.domain.Livro;
import br.edu.ifsp.biblioteca.domain.Usuario;
import br.edu.ifsp.biblioteca.exception.RegraDeNegocioException;
import br.edu.ifsp.biblioteca.repository.LivroRepositoryEmMemoria;
import br.edu.ifsp.biblioteca.repository.UsuarioRepositoryEmMemoria;
import br.edu.ifsp.biblioteca.service.LivroService;
import br.edu.ifsp.biblioteca.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;

@Component
public class CatalogoRunner implements CommandLineRunner {

    private final LivroService livroService;
    private final UsuarioService usuarioService;

    public CatalogoRunner(
            LivroService livroService,
            UsuarioService usuarioService
    ) {
        this.livroService = livroService;
        this.usuarioService = usuarioService;
    }

    public void run(String... args){

        System.out.println();
        System.out.println("===Biblioteca IFSP - v0 (tudo em memória) ===");

        Livro mistBorn = new Livro(
                "9788508145607",
                "Mistborn - Império Final",
                2020
        );

        this.livroService.cadastrar(mistBorn);
        this.livroService.adicionarAutor(mistBorn.getId(), "Brandon Sanderson");
        this.livroService.adicionarExemplar(mistBorn.getId(), "IF-001");
        this.livroService.adicionarExemplar(mistBorn.getId(), "IF-002");

        Livro vidasSecas = new Livro(
                "9788508145608",
                "Vidas Secas",
                1938
        );

        this.livroService.cadastrar(vidasSecas);
        this.livroService.adicionarAutor(vidasSecas.getId(), "Graciliano Ramos");
        this.livroService.adicionarExemplar(vidasSecas.getId(), "VS-001");
        this.livroService.adicionarExemplar(vidasSecas.getId(), "VS-002");

        this.usuarioService.cadastar(new Usuario("Ana Souza", "ana@ifsp.edu.br"));
        this.usuarioService.cadastar(new Usuario("Breno Lima", "breno@ifsp.edu.br"));

        System.out.println();
        System.out.println("-- Catálogo --");

        for(Livro livro: this.livroService.listarTodos()){
            System.out.println(" " + livro);
        }

        System.out.println();
        System.out.println("-- Usuários --");

        for(Usuario usuario: this.usuarioService.listarTodos()){
            System.out.println(" " + usuario);
        }

        System.out.println();
        System.out.println("-- Buscar por título contendo 'casmurro' --");

        List<Livro> encontrados = this.livroService.buscarPorTitulo("mistborn");

        for(Livro livro: encontrados){
            System.out.println(" " + livro);
        }

        System.out.println();
        System.out.println("-- Testando cadastrar o mesmo isbn' --");

        try {
            this.livroService.cadastrar(
                new Livro(
                        "9788508145608",
                        "Vidas Secas",
                        1938
                )
            );

        }catch (RegraDeNegocioException erro){
            System.out.println(" Regra de negócio impediu: " + erro.getMessage());
        }

    }
}
