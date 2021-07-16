/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import Jugadores.Conductor;
/**
 *
 * @author diego
 */
public class Carro {

    protected Conductor conductor;
    protected Integer distancia;
    protected JuegoId juegoId;
    private final Map<CarroId, Conductor> carros = new HashMap<>();

    public Carro() {
    }

    public Carro(Conductor conductor, Integer distancia, JuegoId juegoId) {
        this.conductor = conductor;
        this.distancia = distancia;
        this.juegoId = juegoId;
    }

    public void asignarConductor(Id_carro carroId, Conductor conductor) {
        carros.put(carroId, conductor);

    }

    public Map<CarroId, Conductor> carros() {
        return carros;

    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer numeroCarros() {
        return carros.size();
    }

    public Conductor conductor() {

        return conductor;

    }

    public Integer distancia() {

        return distancia;

    }


}
