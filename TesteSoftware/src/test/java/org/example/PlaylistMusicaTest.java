package org.example;

import org.example.PlaylistMusica.Musica;
import org.example.PlaylistMusica.PlaylistMusica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistMusicaTest {

    private PlaylistMusica playlistMusica;

    @BeforeEach
    public void setUp() {
        playlistMusica = new PlaylistMusica("Playlist Fennekin");
    }

    @Test
    public void adicionarMusicaTest() {
        Musica musica = new Musica("Fennekin", "Pokemon", 3);
        playlistMusica.adicionarMusica(musica);
        assertEquals(1, playlistMusica.getQuantidadeMusicas());
        assertEquals(true, playlistMusica.adicionarMusica(musica));
    }

    @Test
    public void removerMusicaTest() {
        Musica musica = new Musica("Fennekin", "Pokemon", 3);
        playlistMusica.adicionarMusica(musica);
        assertEquals(true, playlistMusica.removerMusica(musica));
    }

    @Test
    public void buscarMusicaPorTituloTest() {
        Musica musica = new Musica("Fennekin", "Pokemon", 3);
        playlistMusica.adicionarMusica(musica);
        assertEquals(musica, playlistMusica.buscarMusicaPorTitulo("Fennekin"));
    }

    @Test
    public void buscarMusicasPorArtistaTest() {
        Musica musica = new Musica("Fennekin", "Pokemon", 3);
        playlistMusica.adicionarMusica(musica);
        assertEquals(1, playlistMusica.buscarMusicasPorArtista("Pokemon").size());
    }

    @Test
    public void getNomeTest() {
        assertEquals("Playlist Fennekin", playlistMusica.getNome());
    }

    @Test
    public void setNomeTest() {
        playlistMusica.setNome("Playlist Charmander");
        assertEquals("Playlist Charmander", playlistMusica.getNome());
    }

    @Test
    public void ordenarPorTituloTest() {
        Musica musica1 = new Musica("Fennekin", "Pokemon", 3);
        Musica musica2 = new Musica("Charmander", "Pokemon", 3);
        playlistMusica.adicionarMusica(musica1);
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.ordenarPorTitulo();
        assertEquals(musica2, playlistMusica.getMusicas().get(0));
    }

    @Test
    public void ordenarPorArtistaTest() {
        Musica musica1 = new Musica("Fennekin", "Pokemon", 3);
        Musica musica2 = new Musica("Charmander", "Pokemon", 3);
        playlistMusica.adicionarMusica(musica1);
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.ordenarPorArtista();
        assertEquals(musica1, playlistMusica.getMusicas().get(0));
    }


}
