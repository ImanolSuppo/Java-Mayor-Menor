package ar.edu.utn.frc.tup.lciii;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Jugador {
    private String nombre;
    private int partidasPerdidas;
    private int partidasGanadas;

    public void aumentarPartidasGanadas(){
        partidasGanadas++;
    }
    public void aumentarPartidasPerdidas(){
        partidasGanadas++;
    }
}
