/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
/**
 *
 * @author kauzar
 */
/*1. Escribe un programa que pida dos números reales por teclado y muestre por pantalla
el resultado de multiplicarlos. Implementa y utiliza la función:
double multiplica(double a, double b) // Devuelve la multiplicación de dos números*/
public class Ejercicio1 {

 /** La función inicializarPartida */
    public static String[][] inicializarPartida (int N) {  
        // Guardamos toda la informacion de los jugadores sobre nombre
        //y puntos en la matriz.
        String matrizJugadores [][]= new String[N][2];
        /** Recorremos la matriz y rellenamos en la posicion [X][0] el
        nombre y en la posicion [X][1] los puntos*/
        for(int i=0;i<matrizJugadores.length;i++){
            for(int c=0;c<matrizJugadores[i].length;c++) {
                System.out.println("Introduce el nombre del jugador: ");
                Scanner entrada2 = new Scanner (System.in);
                matrizJugadores[i][c]=entrada2.nextLine();
                c=c+1;
                // Poner el marcador de cada jugador a cero puntos
                matrizJugadores[i][c]=Integer.toString(0);
            }
        }
        return matrizJugadores;
    }
    public static String preguntaAleatoria () {
        int numerosEnteros= (int)(Math. random()*(8-4)+4);
        System.out.println ("El jugador debe calcular el resultado de una expresion matematica de "+numerosEnteros+" enteros");
        int valorAleatorio= (int)(Math. random()*(12-2)+2);
        String expresion= Integer.toString(valorAleatorio);
        for(int i=0;i<numerosEnteros-1;i++){
            int operacionMat=(int)(Math. random()*(2));// Numero entero aleatorio entre 0 y 2
            valorAleatorio= (int)(Math. random()*(12-2)+2);
            switch(operacionMat)
            {
                case 0:// Operacion Multiplicacion '*'
                    expresion=expresion+"*"+valorAleatorio;
                    break;
                case 1:// Operacion suma '+'
                    expresion=expresion+"+"+valorAleatorio;
                    break;
                case 2:// Operacion resta '-'
                    expresion=expresion+"-"+valorAleatorio;
                    break;
            }
        }
        return expresion;
    }

    public static int evaluarExpresion (String expresion) {
        int valor = 0;
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            Object result = engine.eval(expresion);
            valor = Integer.decode(result.toString());
            
        } catch (Exception e) {
            e.getMessage();
        }
        return valor;
    }

    public static void finRonda (int[][] matriz,int ronda) {
        // Mostrar los puntos de los jugadores en cada ronda recorriendo las columnas de la matriz
        for(int c=0;c<matriz[ronda].length;c++) {
            // se muestra lo siguiente para c=0 , ejemplo: "El jugador 1 tiene 0 punto"
            System.out.println("El jugador "+(c+1)+" tiene "+matriz[ronda][c]+" punto");
        }
    }

    public static String[][] puntuacionesFinales (int[][] matriz, String[][] matrizJugadores) {
        System.out.println("Las puntuaciones finales de todos los jugadores son: ");
        // Recorremos la matriz de puntos (columnas por filas)
        for(int c=0;c<matriz[0].length;c++) {
            int sumaPuntos=0;
            for(int i=0;i<matriz.length;i++){
                sumaPuntos += matriz[i][c]; // Sumamos los puntos de cada jugador
            }
            // Actualizar las puntuaciones finales de cada jugador en la matriz de jugadores creada al iniciar la partida
            matrizJugadores[c][1]=Integer.toString(sumaPuntos);
            // Mostrar las puntuaciones finales de todos los jugadores
            System.out.println("El jugador "+matrizJugadores[c][0]+" tiene "+matrizJugadores[c][1]+" puntos");
        }
        return matrizJugadores;
    }

    public static void mostrarGanador(String[][] matrix){
        int puntuacionMayor = 0;
        int posicionMayor = 0;
        // Comparamos todos los puntos de los jugadores para ver quien tiene más puntuación recorriendo la matriz de jugadores 
        for(int f=0;f<matrix.length;f++){
            int temp=Integer. valueOf(matrix[f][1]);
            if (temp > puntuacionMayor) {
                puntuacionMayor = temp;
                posicionMayor=f;
            }
        }
        // Mostramos por pantalla el ganador de la partida
        System.out.println("El ganador de esta partida es el jugador "+matrix[posicionMayor][0]+" con una puntuacion total de: "+puntuacionMayor+" puntos");
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaramos las variables del numero de jugadores , numero de rondas de la partida y la respuesta del usuario a la pregunta de la ronda (resultadoUser)
        int jugadores, rondas,resultadoUser;
        //Pedir al usuario que introduzca los datos necesarios
        Scanner entrada = new Scanner (System.in);
        System.out.println ("------------------- Inicio de partida -------------------");
        //Mostramos al usuario por pantalla que introduzca el Nº de jugadores de la partida
        System.out.println ("Introduce el número de jugadores de 1 a 6 ");
        // Leemos el numero de jugadores y lo guardamos en la variable jugadores
        jugadores=entrada.nextInt();
        // Llamos a la funcion inicializar partida y guardamos en matJug, la matriz de jugadores inicializada
        String matJug [][]=inicializarPartida (jugadores);
        // Mostramos al usuario por pantalla que introduzca el numero de rondas de la partida
        System.out.println ("¿Qué tipo de de partida queréis? Elige entre las siguientes opciones 3 (partida rápida), 5 (partida corta), 10(partida normal) o 20 (partida larga) ");
        // Leemos el numero de rondas y lo guardamos en la variable rondas
        rondas=entrada.nextInt();
        while(rondas!=3 && rondas!=5 && rondas!=10 && rondas!=20){
            System.out.println ("No se puede empezar la partida con este numero de rondas,por favor vuelve a elegir entre las siguientes opciones 3 (partida rápida), 5 (partida corta), 10(partida normal) o 20 (partida larga) ");
            rondas=entrada.nextInt();
        }
        // Empezamos a jugar la partida
        System.out.println ("------------------- Jugar partida -------------------");
        // Inicializar contRondas = 0
        int contRondas=0;
        // Declaramos una matriz de R rondas (filas) por N jugadores (columnas)
        int matriz [][]= new int[rondas][jugadores];
        while (contRondas<rondas){
            // Inicializar contJugadores = 0
            int contJugadores=0;
            while (contJugadores<jugadores){
                // Llamamos a la funcion de pregunta aleatoria para mostrarle al usuario la expresion matematica que debe calcular
                String expMat = preguntaAleatoria();
                // Utilizando la funcion facilitada por la profesora, calculamos el resultado de la expresion matematica para compararlo con la respuesta de usuario
                int res = evaluarExpresion (expMat);
                // Mostar al usuario por pantalla la expresion matematica que debe calcular y el resultado para que facilitar el correcto funcionamiento del codigo
                System.out.println("Calcula el resultado de la expresión matemática " +expMat+ " es: "+res);
                // Leemos la respuesta del usuario y la guardamos en la variable "resultadoUser"
                resultadoUser=entrada.nextInt();
                // Si la respuesta del usuario es correcta, entonces le damos un punto y lo guardamos en la posicion correcta
                if (res==resultadoUser){
                    matriz[contRondas][contJugadores]=1;
                }
                // Sino, le mostramos por pantalla que su respuesta ha sido incorrecta y el resultado esperado de la pregunta, y le damos un 0 punto
                else{
                    System.out.println("¡Respuesta incorrecta! y el resultado esperado es: "+res);
                    matriz[contRondas][contJugadores]=0;
                }
                // En la misma ronda, pasamos a preguntar al jugador siguiente
                contJugadores++;
            }
            //Mostrar puntos de los N jugadores al acabar la ronda recorriendo la matriz, para ello llamamos a la funcion finRonda
            System.out.println("Los puntos de los "+jugadores+" jugadores de la ronda "+(contRondas+1)+" son: ");
            finRonda (matriz,contRondas);
            // Pasamos a la ronda siguiente
            contRondas++; 
        }
        //Mostrar puntuaciones finales recorriendo la matriz de todos los jugadores, para ello llamamos a la funcion puntuaciones finales
        String matJugFinales [][]=puntuacionesFinales (matriz,matJug);
        // Comparamos todos los puntos de los jugadores para ver quien tiene más puntos y mostramos el ganador por pantalla
        // Para ello llamamos a la funcion mostrar ganador
        mostrarGanador(matJugFinales);
        System.out.println ("------------------- Fin de partida -------------------");
    }
    
}