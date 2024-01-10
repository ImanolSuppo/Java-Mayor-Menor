package ar.edu.utn.frc.tup.lciii;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    @DisplayName("Test con metodo publico")
    public void testCase1(){
        Game juego = new Game();
        juego.iniciar();
        assertEquals("Iniciando juego..." + System.lineSeparator() +
                "Mezclando cartas..." + System.lineSeparator(), getOutput());
    }
    private String getOutput() {
        return testOut.toString();
    }
}
