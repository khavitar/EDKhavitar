/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kauzar
 */
public class Ejercicio1Test {
    
    public Ejercicio1Test() {
    }
    /**
     * Test of valida method, of class Ejercicio1.
     */
    @Test
    public void testJugadores() {
        //caso1
        System.out.println("valida");
        jugadores jugadoresValidos = new jugadores(1);
        boolean result = jugadoresValidos.valida();
        assertTrue(result);
        //caso2
        System.out.println("valida");
        jugadores jugadoresValidos = new jugadores(2);
        result = jugadoresValidos.valida();
        assertTrue(result);
//caso3
        System.out.println("valida");
        jugadores jugadoresValidos = new jugadores(3);
        result = jugadoresValidos.valida();
        assertTrue(result);
//caso4
        System.out.println("valida");
        jugadores jugadoresValidos = new jugadores(4);
        result = jugadoresValidos.valida();
        assertTrue(result);
//caso5
        System.out.println("valida");
        jugadores jugadoresValidos = new jugadores(5);
        result = jugadoresValidos.valida();
        assertTrue(result);
//caso6
        System.out.println("valida");
        jugadores jugadoresValidos = new jugadores(6);
        result = jugadoresValidos.valida();
        assertTrue(result);
//caso7
        System.out.println("No valida");
        jugadores jugadoresValidos = new jugadores(7);
        result = jugadoresValidos.valida();
        assertFalse(result);
    
    }    
    
}
