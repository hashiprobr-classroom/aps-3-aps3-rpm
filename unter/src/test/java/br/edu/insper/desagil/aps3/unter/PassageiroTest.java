package br.edu.insper.desagil.aps3.unter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassageiroTest {
    private static final double DELTA = 0.0001;

    private Passageiro passageiro;
    private Corrida corrida;

    @BeforeEach
    public void setup() {
        passageiro = new Passageiro("123", "Carlos");
        corrida = new Corrida(passageiro);
    }

    @Test
    public void constroi() {
        assertEquals("123", passageiro.getCpf());
        assertEquals("Carlos", passageiro.getNome());
    }

    @Test
    public void mudaNome() {
        passageiro.setNome("João");
        assertEquals("João", passageiro.getNome());
    }

    @Test
    public void avalia() {
        passageiro.avalia(corrida, 3);
        assertEquals(3, corrida.getNota_m(), DELTA);
    }

    @Test
    public void avaliaBaixo() {
        passageiro.avalia(corrida, 0);
        assertEquals(1, corrida.getNota_m(), DELTA);
    }

    @Test
    public void avaliaAlto() {
        passageiro.avalia(corrida, 6); // Deve ser truncado para 5
        assertEquals(5, corrida.getNota_m(), DELTA);
    }
}
