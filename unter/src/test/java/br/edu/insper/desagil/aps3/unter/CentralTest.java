package br.edu.insper.desagil.aps3.unter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CentralTest {

    private Central centralReal;
    private static final double DELTA = 0.0001;


    @BeforeEach
    void configurar() {
        centralReal = new Central();
    }
    private Corrida criarCorridaFalsa(String cpfPassageiro, int notaPassageiro,
                                      String cpfMotorista, Integer notaMotorista) {


        Passageiro passageiroFalso = mock(Passageiro.class);
        when(passageiroFalso.getCpf()).thenReturn(cpfPassageiro);

        Motorista motoristaFalso = null;
        if (cpfMotorista != null) {
            motoristaFalso = mock(Motorista.class);
            when(motoristaFalso.getCpf()).thenReturn(cpfMotorista);
        }


        Corrida corridaFalsa = mock(Corrida.class);


        when(corridaFalsa.getPassageiro()).thenReturn(passageiroFalso);
        when(corridaFalsa.getNota_p()).thenReturn(notaPassageiro);


        when(corridaFalsa.getMotorista()).thenReturn(motoristaFalso);
        if (notaMotorista != null) {
            when(corridaFalsa.getNota_m()).thenReturn(notaMotorista);
        }

        return corridaFalsa;
    }

    @Test
    void nenhumaAvaliacaoPassageiro() {

        String cpf = "111.222.333-44";
        double media = centralReal.mediaPassageiro(cpf);

        assertEquals(0.0, media, DELTA);
    }

    @Test
    void nenhumaAvaliacaoMotorista() {

        String cpf = "999.888.777-66";
        double media = centralReal.mediaMotorista(cpf);

        assertEquals(0.0, media, DELTA);
    }

    @Test
    void avaliacoesPassageiro() {
        String cpfPassageiroPrincipal = "123.456.789-00";
        String cpfPassageiroSecundario = "987.654.321-11";

        Corrida c1 = criarCorridaFalsa(cpfPassageiroPrincipal, 0, null, null);
        Corrida c2 = criarCorridaFalsa(cpfPassageiroPrincipal, 4, null, null);
        Corrida c3 = criarCorridaFalsa(cpfPassageiroPrincipal, 5, null, null);
        Corrida c4 = criarCorridaFalsa(cpfPassageiroSecundario, 3, null, null);

        centralReal.adiciona(c1);
        centralReal.adiciona(c2);
        centralReal.adiciona(c3);
        centralReal.adiciona(c4);

        double media = centralReal.mediaPassageiro(cpfPassageiroPrincipal);
        assertEquals(4.5, media, DELTA);
    }

    @Test
    void avaliacoesMotorista() {

        String cpfMotoristaPrincipal = "555.666.777-88";
        String cpfMotoristaSecundario = "444.333.222-11";

        Corrida c1 = criarCorridaFalsa(null, 0, cpfMotoristaPrincipal, 0);
        Corrida c2 = criarCorridaFalsa(null, 0, cpfMotoristaPrincipal, 2);
        Corrida c3 = criarCorridaFalsa(null, 0, cpfMotoristaPrincipal, 3);

        Corrida c4 = criarCorridaFalsa(null, 0, cpfMotoristaSecundario, 1);

        Corrida c5 = criarCorridaFalsa(null, 0, null, 1);

        centralReal.adiciona(c1);
        centralReal.adiciona(c2);
        centralReal.adiciona(c3);
        centralReal.adiciona(c4);
        centralReal.adiciona(c5);

        double media = centralReal.mediaMotorista(cpfMotoristaPrincipal);
        assertEquals(2.5, media, DELTA);
    }
}
