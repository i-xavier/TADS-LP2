package br.edu.ifsp.biblioteca;
import br.edu.ifsp.biblioteca.domain.Livro;

public class BibliotecaApplication {
    public static void main(String[] args) {
        System.out.println("Olá, Mundo");

        Livro livro = new Livro(
                1L,
                "9788508145607",
                "Mistborn - Império Final",
                2020
        );
        System.out.println(livro);

        Livro livro2 = new Livro(
                2L,
                "9788508126607",
                "Dom Quixote",
                2026
        );
        System.out.println(livro2);

        Livro livro3 = new Livro(
                3L,
                "9186528145607",
                "Crime e Castigo",
                2001
        );
        System.out.println(livro3);
    }
}
