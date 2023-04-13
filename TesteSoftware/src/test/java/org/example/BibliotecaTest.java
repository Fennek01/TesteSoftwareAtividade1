package org.example;

import org.example.Biblioteca.Biblioteca;
import org.example.Biblioteca.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca do IFPB");
    }

    @Test
    public void AdicionarLivroTest() {
        Livro livro = new Livro("Java", "Autor", "Java", 2019);
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.getQuantidadeLivros());
        assertEquals(true, biblioteca.adicionarLivro(livro));
    }

    @Test
    public void RemoverLivroTest() {
        Livro livro = new Livro("Java", "Autor", "Java", 2019);
        biblioteca.adicionarLivro(livro);
        assertEquals(true, biblioteca.removerLivro(livro));
    }

    @Test
    public void buscarLivroPorTituloTest() {
        Livro livro = new Livro("Java", "Autor", "Java", 2019);
        biblioteca.adicionarLivro(livro);
        assertEquals(livro, biblioteca.buscarLivroPorTitulo("Java"));
    }

    @Test
    public void buscarLivrosPorAutorTest() {
        Livro livro = new Livro("Java", "Autor", "Java", 2019);
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.buscarLivrosPorAutor("Autor").size());
    }

    @Test
    public void buscarLivrosPorGeneroTest() {
        Livro livro = new Livro("Java", "Autor", "Java", 2019);
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.buscarLivrosPorGenero("Java").size());
    }

    @Test
    public void getNomeTest() {
        assertEquals("Biblioteca do IFPB", biblioteca.getNome());
    }

    @Test
    public void setNomeTest() {
        biblioteca.setNome("Biblioteca do Fennek");
        assertEquals("Biblioteca do Fennek", biblioteca.getNome());
    }

    @Test
    public void getLivrosTest() {
        Livro livro1 = new Livro("Java", "Autor", "Java", 2019);
        Livro livro2 = new Livro("Python", "Autor", "Python", 2000);
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        assertEquals(2, biblioteca.getLivros().size());
    }

}
