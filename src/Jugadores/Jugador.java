/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugadores;
/**
 *
 * @author diego
 */
public class Jugador {
    private Nombre nombre;
    private Integer puntos;

    public Jugador(Nombre nombre, Integer puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public Nombre nombre() {
        return nombre;
    }


    public void asignarPuntos(Integer puntos) {
        puntos = puntos;
    }

}
