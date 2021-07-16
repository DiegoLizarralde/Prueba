/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pista;

/**
 *
 * @author diego
 */
public class Pista {

    String nombre;//nombre de la pista
    int carriles;//numero de carriles
    int limDistancia;//tamaño en kilometros de la pista

    public Pista(String nombre, int carriles, int limDistancia) {
        this.nombre = nombre;
        this.carriles = carriles;
        this.limDistancia = limDistancia;
    }

    //asociada al carril
    int numerocarril;
    int longitudcarril;
    int posicioncarro;

    //numero de carriles, construimos un arreglo de onjetos de tipo carril
    Carril objcarril[] = new Carril[carriles];// el tamaño del arreglo de objetos de tipo carril será la cantidad de carriles que recibimos de la clase principal.

    //metodo para validar la longitud de los carriles deacuero a la longitud de la pista
    //para este metodo le asignamos a la pista un valor (en la clase principal, no acá), y ese valor se lo asignamos a 
    //la longitud de los carriles
    public void asignalongitud(int longitudpista) //recibe como parametro la longitud de la pista
    {
        int i = 0;
        while (i < objcarril.length) //mientras la variable i sea menor al tamaño del arreglo tipo carril (osea menor que la longitud en kilometros de la pista).
        {
            objcarril[i].longitud = longitudpista; //el carril actual va a tener una longitud del tamaño del parametro que recibio.
            i += 1; //incrementa el valor de la variable auxiliar i.
        }
    }

    //metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCarriles() {
        return carriles;
    }

    public void setCarriles(int carriles) {
        this.carriles = carriles;
    }

    public int getLimDistancia() {
        return limDistancia;
    }

    public void setLimDistancia(int limDistancia) {
        this.limDistancia = limDistancia;
    }
}
