/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pista;

import juego_carros.Carro;

/**
 *
 * @author diego
 */
public class Carril {

    int numerodecarril;
    int longitud;
    int posicioncarro;

    public Carril(int numerodecarril, int longitud, int posicioncarro) {
        this.numerodecarril = numerodecarril;
        this.longitud = longitud;
        this.posicioncarro = posicioncarro;
    }

    //asociado al carro
    //atributos del carro
    String nom;
    String marca;
    String color;
    int id;
    int numcarril;
    //objeto de tipo carro
    Carro objcarro = new Carro(nom, marca, color, id, numcarril);

    //metodo para que el carro avance en el carril de acuerdo al dado que se arrojo en el metodo dado de la clase carro
    //para este metodo (avance), se recibe el valor definido en la clase principal que será igual a cero, 
    //longitud del carril; y devuelve el valor nuevo de dicha posicion.
    public int avance(int d) { //la d es el valor del dado
        d = objcarro.dado();
        posicioncarro = posicioncarro + d;
        return posicioncarro;
    }

    //metodo para actualizar la posicion del carro en el carril
    public int posicion(int d) {
        //d= this.avance(d) ;

        posicioncarro = (longitud * 1000) - this.avance(d);//multiplica por 1000 el numero de kilometros para pasarlo a metros, luego le resta el avance

        return posicioncarro;
    }

    //metodos get y set
    public int getNumerodecarril() { //los get sirven para devolder o mostrar los valores de las variables del metodo constructor
        return numerodecarril;
    }

    public void setNumerodecarril(int numerodecarril) { //los set sirven para modificar los valores de las variables del constructor
        this.numerodecarril = numerodecarril;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getPosicioncarro() {
        return posicioncarro;
    }

    public void setPosicioncarro(int posicioncarro) {
        this.posicioncarro = posicioncarro;
    }
}
