package br.edu.insper.desagil.aps3.unter;

public class Corrida {
    private Passageiro passageiro;
    private Motorista motorista;
    private int nota_p;
    private int nota_m;

    public Corrida(Passageiro passageiro) {
        this.passageiro = passageiro;
        this.motorista = null;
        this.nota_p = 0;
        this.nota_m = 0;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public int getNota_p() {
        return nota_p;
    }

    public int getNota_m() {
        return nota_m;
    }

    private int ajustaNota(int nota) {
        if (nota<1) {
            return 1;
        }
        else if (nota>5) {
            return 5;
        }
        return nota;
    }

    public void avaliaPassageiro(int valor) {
        nota_p = ajustaNota(valor);
    }

    public void avaliaMotorista(int valor) {
        nota_m = ajustaNota(valor);
    }
}
