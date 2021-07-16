/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

import DB.GanadoresDB;
import Jugadores.Jugador;
import Pista.Carril;
import Pista.Pista;
import Carrera.Carro;
import Carrera.Id_carro;
import Jugadores.Conductor;
import Jugadores.Id_jugador;
import Jugadores.Nombre;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author diego
 */
public class Juego {

    public Juego() {

    }

    protected Map<Id_jugador, Jugador> jugadores = new HashMap<>();
    protected Pista pista;
    protected Podio podio = new Podio();
    protected Boolean jugando;
    protected ArrayList<Pista> pistas = new ArrayList<>();
    protected ArrayList<Carro> carros_En_Carrera = new ArrayList<>();
    protected ArrayList<Carril> Carriles_En_Juego = new ArrayList<>();
    protected ArrayList<GanadoresDB> ganadores = new ArrayList<>();
    private final Carro carro = new Carro();
    private Boolean primeraPartida = true;

    //Crear Jugador
    public void Crear_Jugador(Id_jugador Id_jugador, Nombre nombre) {
        Jugador jugador = new Jugador(nombre, 0);
        jugadores.put(Id_jugador, jugador);
        crearConductor(nombre);
    }
    
    //Crear Conductor
     public void crearConductor(Nombre nombre) {
        UUID id;
        Scanner in = new Scanner(System.in);
        System.out.println("Desea que el jugador con nombre: " + nombre.getNombre() + " sea conductor ? " + "Y/N");
        while (!in.hasNext("[yYnN]")) {
            System.out.println("Solo se reciben como respuesta Y/N ó y/n");
            in.next();
        }
        String consultaConductores = in.next();
        if (consultaConductores.equals("Y") || consultaConductores.equals("y")) {
            Conductor conductor = new Conductor(nombre.getNombre());
            id = UUID.randomUUID();
            Id_carro Id_carro = new Id_carro(id);
            carro.asignarConductor(Id_carro, conductor);
        }
    }

     //Creación de pista con sus respectivos numeros de carriles deacuerdo a el numero de jugadores y tambien
     //su respectiva distancia (kilometros)
    public void crearPistas() {
        int kilometrosRandom;
        int numeroCarriles = carro.numeroCarros();
        for (int i = 0; i < carro.numeroCarros(); i++) {
            kilometrosRandom = (int) (Math.random() * 100 + 1);
            Pista pista = new Pista(kilometrosRandom, numeroCarriles);
            pistas.add(pista);
        }
    }
    
    //Asignacion de puestos

    public void asignarPrimerLugar(JugadorId jugadorId) {
        podio.asignarPrimerLugar(jugadores.get(jugadorId));
        System.out.println("**********" + jugadores.get(jugadorId).nombre().getNombre() + ": Primer Lugar" + "***********");

    }

    public void asignarSegundoLugar(JugadorId jugadorId) {
        podio.asignarSegundoLugar(jugadores.get(jugadorId));
        System.out.println("**********" + jugadores.get(jugadorId).nombre().getNombre() + ": Segundo Lugar" + "***********");
    }

    public void asignarTercerLugar(JugadorId jugadorId) {
        podio.asignarTercerLugar(jugadores.get(jugadorId));
        System.out.println("**********" + jugadores.get(jugadorId).nombre().getNombre() + ": Tercer Lugar" + "***********");

    }
    
    public void iniciarJuego() {
        UUID id;
        id = UUID.randomUUID();
        JuegoId juegoId = new JuegoId(id);

        //Lista de pistas a elegir
        Scanner in = new Scanner(System.in);
        System.out.println("Para iniciar el juego, elige la  pista (numero) en la que deseas jugar:  ");
        System.out.println("Pistas: ");
        int counter = 1;
        for (Pista p : pistas) {
            System.out.println(counter + "." + " Kilometros: " + p.kilometros() + " Número de carriles:  " + p.numeroDeCarriles());
            counter++;
        }
        while (!in.hasNextInt()) {
            in.next();
        }
        int pistaElegida = in.nextInt();

        carro.carros().forEach((key, value) -> {
            Carro carrosJuego = new Carro(value, 0, Color.yellow, juegoId);
            carrosEnJuego.add(carrosJuego);

            //añadir carros a los Carriles para jugar
            int kilometrosToMetros = pistas.get(pistaElegida - 1).kilometros() * 1000;
            Posicion posicion = new Posicion(0, kilometrosToMetros);
            Carril carriles = new Carril(key, juegoId, posicion, kilometrosToMetros, false);
            carrilesEnJuego.add(carriles);
        });

        //Arranca el juego
        jugando = true;
        Conductor conductor = new Conductor();
        System.out.println("----------Inicia la carrera--------");

        //Mientras no hayan 3 ganadores el juego continua
        while (jugando) {
            int contador = 0;
            System.out.println("--------Avance----- " + "--------- Meta: " + carrilesEnJuego.get(contador).metros() + " metros");
            for (Carro carros : carrosEnJuego) {

                //Si el carro no ha ganado sigue jugando
                if (!yaGanoCarro(carros.conductor().nombre())) {
                    int mover = conductor.lanzarDado() * 100;
                    carros.setDistancia(carros.distancia() + mover);
                    carrilesEnJuego.get(contador).moverCarro(carrilesEnJuego.get(contador).posicion(), mover);
                    System.out.println(carros.conductor().nombre() + ":" + " mueve: " + mover + " Nueva posición: " + carros.distancia());

                    //Si el jugador llego a la final, asignarle la posición y el podio
                    if (carrilesEnJuego.get(contador).desplazamientoFinal()) {
                        if (podio.primerLugar() == null) {
                            asignarPrimerLugar(jugadorID(carros.conductor().nombre()));
                        } else if (podio.segundoLugar() == null) {
                            asignarSegundoLugar(jugadorID(carros.conductor().nombre()));
                        } else if (podio.tercerLugar() == null) {
                            asignarTercerLugar(jugadorID(carros.conductor().nombre()));
                        }
                    }
                }
                contador++;
            }
            if (podio.estaLleno()) {
                break;
            }
        }

        mostrarPodio();
        guardarRegistroBD();
        repetirJuego();
    }

    public Map<JugadorId, Jugador> jugadores() {

        return jugadores;

    }

    public Boolean jugando() {

        return jugando;

    }

    // Retorna el id del jugador dando el nombre del jugador
    public JugadorId jugadorID(String nombre) {
        JugadorId lookId = null;
        for (JugadorId keys : jugadores.keySet()) {
            if (jugadores.get(keys).nombre().getNombre().equals(nombre)) {
                lookId = keys;
            }
        }
        return lookId;
    }

    //Retorna True  si el carro en la carrera ya ganó
    public Boolean yaGanoCarro(String nombre) {
        boolean yaGano = false;
        if (podio.tercerLugar() == jugadores.get(jugadorID(nombre))
                || podio.primerLugar() == jugadores.get(jugadorID(nombre))
                || podio.segundoLugar() == jugadores.get(jugadorID(nombre))) {
            yaGano = true;
        }
        return yaGano;
    }


}
