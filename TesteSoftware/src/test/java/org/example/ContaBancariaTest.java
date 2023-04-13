package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaBancariaTest {

    ContaBancaria contaBancaria;

    @BeforeEach
    public void setUp() {
        contaBancaria = new ContaBancaria("0101010101", "Fennekin");
    }

    @Test
    public void getNumeroTest() {
        assertEquals("0101010101", contaBancaria.getNumeroConta());
    }

    @Test
    public void getNomeTest() {
        assertEquals("Fennekin", contaBancaria.getTitular());
    }

    @Test
    public void getSaldoTest() {
        contaBancaria.depositar(100);
        assertEquals(100, contaBancaria.getSaldo());
    }

    @Test
    public void depositarTest() {
        contaBancaria.depositar(1000);
        assertEquals(1000, contaBancaria.getSaldo());
    }

    @Test
    public void sacarTest() {
        contaBancaria.depositar(1000);
        contaBancaria.sacar(500);
        assertEquals(500, contaBancaria.getSaldo());
    }

    @Test
    public void transferirTest() {
        ContaBancaria contaDestino = new ContaBancaria("0202020202", "Charmander");
        contaBancaria.depositar(1000);
        contaBancaria.transferir(contaDestino, 500);
        assertEquals(500, contaBancaria.getSaldo());
        assertEquals(500, contaDestino.getSaldo());
    }

    @Test
    public void getTaxaJurosTest() {
        contaBancaria.setTaxaJuros(1000);
        assertEquals(1000, contaBancaria.getTaxaJuros());
    }

    @Test
    public void setTaxaJurosTest() {
        contaBancaria.setTaxaJuros(1000);
        assertEquals(1000, contaBancaria.getTaxaJuros());
    }

    @Test
    public void alterarTitularTest() {
        contaBancaria.alterarTitular("Charmander");
        assertEquals("Charmander", contaBancaria.getTitular());
    }

    @Test
    public void aplicarJurosTest() {
        contaBancaria.depositar(1000);
        contaBancaria.setTaxaJuros(0.1);
        contaBancaria.aplicarJuros();
        assertEquals(1100, contaBancaria.getSaldo());
    }

}
