package ar.edu.utn.frc.tup.lciii;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Game {
    private Mazo mazo;
    Carta carta;
    Carta cartaAnterior;

    public int getCantidadCartas() {
        return cantidadCartas -1;
    }

    public void setCantidadCartas(int cantidadCartas) {
        this.cantidadCartas = cantidadCartas;
    }

    private int cantidadCartas;

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public Carta getCartaAnterior() {
        return cartaAnterior;
    }

    public void setCartaAnterior(Carta cartaAnterior) {
        this.cartaAnterior = cartaAnterior;
    }

    public Game(){
        mazo = new Mazo();

    }

    public void iniciar() {
        System.out.println("Iniciando juego...");
        System.out.println("Mezclando cartas...");
        mazo.mesclarCartas();
        cantidadCartas = 0;
    }

    public void mostrarCarta() {
        //System.out.println("Lanzando carta...");
        carta = mazo.getCartas().get(cantidadCartas);
        System.out.println(carta.toString());
        cantidadCartas ++;
    }

    public boolean esMayor(boolean desicion) {
        cartaAnterior = carta;
        mostrarCarta();
        if(cartaAnterior.getNumero() == carta.getNumero()){
            System.out.println("Son iguales, por lo tanto continua");
            return desicion;
        }
        else if (cartaAnterior.getNumero() < carta.getNumero()) {
            return true;
        }
        else
        return false;
    }

    public boolean quedanCartas() {
        return cantidadCartas <= 40;
    }
}
