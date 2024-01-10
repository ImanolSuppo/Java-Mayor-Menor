package ar.edu.utn.frc.tup.lciii;

public class Carta {
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    private int numero;

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    private Palo palo;
    public Carta(int numero, Palo palo){
        this.numero=numero;
        this.palo=palo;
    }

    @Override
    public String toString() {
        return palo + " | " + numero;
    }
}
