package br.edu.insper.desagil.aps3.unter;

import java.util.ArrayList;
import java.util.List;

public class Central {
    private List<Corrida> corridas;

    public Central() {
        this.corridas = new ArrayList<>();
    }

    public void adiciona(Corrida corrida) {
        corridas.add(corrida);
    }

    public double mediaPassageiro(String cpf) {
        int soma = 0;
        int qtd_notas = 0;

        for (Corrida c : corridas) {
            if (c.getPassageiro().getCpf().equals(cpf)) {
                int nota = c.getNota_p();
                if (nota > 0) {
                    soma += nota;
                    qtd_notas++;
                }
            }
        }

        if (qtd_notas==0) {
            return 0.0;
        }

        return (double) soma / qtd_notas;
    }

    public double mediaMotorista(String cpf) {
        int soma = 0;
        int qtd_notas = 0;

        for (Corrida c : corridas) {
            if (c.getMotorista() != null && c.getMotorista().getCpf().equals(cpf)) {
                int nota = c.getNota_m();
                if (nota > 0) {
                    soma += nota;
                    qtd_notas++;
                }
            }
        }

        if (qtd_notas==0) {
            return 0.0;
        }

        return (double) soma / qtd_notas;
    }
}
