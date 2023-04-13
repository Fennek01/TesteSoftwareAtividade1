package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Estoque.Estoque;
import org.example.Estoque.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstoqueTest {
    
    private Estoque estoque;

    @BeforeEach
    public void setUp() {
        estoque = new Estoque();
    }

    @Test
    public void testAdicionarProduto() {
        Produto produto = new Produto(1, "Caneta", 10);
        estoque.adicionarProduto(produto);
        assertEquals(10, estoque.obterQuantidade(1));

        Produto novoProduto = new Produto(1, "Lápis", 15);
        estoque.adicionarProduto(novoProduto);
        assertEquals(10, estoque.obterQuantidade(1));
    }

    @Test
    public void testRemoverProduto() {
        Produto produto = new Produto(1, "Caneta", 10);
        estoque.adicionarProduto(produto);
        estoque.removerProduto(1);
        assertEquals(-1, estoque.obterQuantidade(1));
    }

    @Test
    public void testAtualizarQuantidade() {
        Produto produto = new Produto(1, "Caneta", 10);
        estoque.adicionarProduto(produto);
        estoque.atualizarQuantidade(1, 20);
        assertEquals(20, estoque.obterQuantidade(1));

        estoque.atualizarQuantidade(2, 15);
        assertEquals(-1, estoque.obterQuantidade(2));
    }

    @Test
    public void testObterQuantidade() {
        Produto produto = new Produto(1, "Caneta", 10);
        estoque.adicionarProduto(produto);
        assertEquals(10, estoque.obterQuantidade(1));

        assertEquals(-1, estoque.obterQuantidade(2));
    }
}
