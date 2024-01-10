package ar.edu.utn.frc.tup.lciii;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Mazo {

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    private List<Carta> cartas;

    public Mazo(){
        cartas = new ArrayList<>();
    }
    public void mesclarCartas() {
        for (int i = 1; i <= 10; i++) {
            if (i == 8){
                cartas.add(new Carta(11,Palo.BASTO));
                cartas.add(new Carta(11,Palo.ORO));
                cartas.add(new Carta(11,Palo.COPA));
                cartas.add(new Carta(11,Palo.ESPADA));
            }
            else if (i == 9) {
                cartas.add(new Carta(12,Palo.BASTO));
                cartas.add(new Carta(12,Palo.ORO));
                cartas.add(new Carta(12,Palo.COPA));
                cartas.add(new Carta(12,Palo.ESPADA));
            } else {
                cartas.add(new Carta(i,Palo.BASTO));
                cartas.add(new Carta(i,Palo.ORO));
                cartas.add(new Carta(i,Palo.COPA));
                cartas.add(new Carta(i,Palo.ESPADA));
            }
        }
        Collections.shuffle(cartas);
    }
}
