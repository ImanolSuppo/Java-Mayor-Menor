package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class AppTest {

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
    public void testMain() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        App.main(null);
        assertEquals("Hello, Practica Parcial 1 - TA TE TI." + System.lineSeparator(),
                getOutput());
    }
    @Test
    @DisplayName("Test con metodo publico")
    public void testCase1(){
        assertTrue(App.isNumeric("28"));
    }
    @Test
    @DisplayName("Test con metodo privado")
    public void testCase2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Jugador jugador = Mockito.mock(Jugador.class);
        when(jugador.getPartidasGanadas()).thenReturn(2);
        when(jugador.getPartidasPerdidas()).thenReturn(0);
        App app = new App();
        Method metodoPrivado = App.class.getDeclaredMethod("resultado", Jugador.class);
        metodoPrivado.setAccessible(true);
        metodoPrivado.invoke(app,jugador);
        assertEquals(
                "----------------------------------------------------" + System.lineSeparator() +
                "Partidas ganadas: 2" + System.lineSeparator() +
                "Partidas perdidas: 0" + System.lineSeparator() +
                "----------------------------------------------------" + System.lineSeparator(), getOutput());
    }
    private String getOutput() {
        return testOut.toString();
    }
}
