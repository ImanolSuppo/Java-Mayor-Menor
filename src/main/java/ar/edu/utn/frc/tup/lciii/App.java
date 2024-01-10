package ar.edu.utn.frc.tup.lciii;

import javax.swing.text.StyledEditorKit;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.function.BinaryOperator;
public class App 
{
    public static void main( String[] args ) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        System.out.println("Hello, Practica Parcial 1 - MAYOR/MENOR.");
        Scanner sc = new Scanner(System.in);
        // Mensaje de Bienvenida
        System.out.println("Bienvenido al juego");
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        Jugador jugador = new Jugador(nombre, 0, 0);
        int continuar = 1;
        do {
            Game juego = new Game();
            juego.iniciar();
            juego.mostrarCarta();
            do {
                System.out.println("La siguente carta... es Mayor?");
                System.out.println("Opciones:");
                System.out.println("True");
                System.out.println("False");
                System.out.println("(Cualquier otra entrada será considerada falsa!)");
                String validar = sc.nextLine();
                boolean desicion = Boolean.parseBoolean(validar);
                if (juego.esMayor(desicion) != desicion){
                    jugador.aumentarPartidasPerdidas();
                    System.out.println("Fallo :(");
                    break;
                }else{
                    System.out.println("Acertó :D");
                    if (!juego.quedanCartas()){
                        jugador.aumentarPartidasGanadas();
                        System.out.println("Felicidad!!! se quedó sin cartas");
                        break;
                    }
                    else {
                        System.out.println("Cantidad de cartas adivinadas: " + juego.getCantidadCartas());
                    }
                }

            }while (true);
            do {
                System.out.println("Desea jugar de nuevo? (1-SI | 2-NO)");
                String validar = sc.nextLine();
                if (isNumeric(validar))
                    continuar = Integer.parseInt(validar);
            }while (continuar != 1 && continuar != 2);
        }while (continuar == 1);
        resultado(jugador);
    }

    private static void resultado(Jugador jugador) {
        System.out.println("----------------------------------------------------");
        System.out.println("Partidas ganadas: " + jugador.getPartidasGanadas());
        System.out.println("Partidas perdidas: " + jugador.getPartidasPerdidas());
        System.out.println("----------------------------------------------------");
    }

    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
