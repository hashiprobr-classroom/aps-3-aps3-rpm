package br.edu.insper.desagil.aps3.unter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotoristaTest {
    private static final double DELTA = 0.0001;

    private Motorista motorista;
    private Corrida corrida;

    @BeforeEach
    public void setup() {
        motorista = new Motorista("456", "Ana");
        Passageiro passageiro = new Passageiro("123", "Carlos");
        corrida = new Corrida(passageiro);
        corrida.setMotorista(motorista);
    }

    @Test
    public void constroi() {
        assertEquals("456", motorista.getCpf());
        assertEquals("Ana", motorista.getNome());
    }

    @Test
    public void mudaNome() {
        motorista.setNome("Mariana");
        assertEquals("Mariana", motorista.getNome());
    }

    @Test
    public void avalia() {
        motorista.avalia(corrida, 3);
        assertEquals(3, corrida.getNota_p(), DELTA);
    }

    @Test
    public void avaliaBaixo() {
        motorista.avalia(corrida, 0);
        assertEquals(1, corrida.getNota_p(), DELTA);
    }

    @Test
    public void avaliaAlto() {
        motorista.avalia(corrida, 6);
        assertEquals(5, corrida.getNota_p(), DELTA);
    }
}
