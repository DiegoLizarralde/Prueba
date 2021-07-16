/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugadores;

import java.util.UUID;

/**
 *
 * @author diego
 */
public class Id_jugador {

    private UUID id;

    public Id_jugador(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}
