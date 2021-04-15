/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_carros;


//librerias importadas

import java.util.Random;//libreria para generar numeros aleatorios


public class Carro {
    String nombre;
    String marca;
    String color;
    int idcarro;
    int Carril;

    public Carro(String nombre, String marca, String color, int idcarro, int Carril) {
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
        this.idcarro = idcarro;
        this.Carril = Carril;
    }
    
    // asociado al conductor
    //atributos del conductor
    String nombreconductor;
    int numeroconductor;
    //objeto tipo conductor
    Conductor objconductor = new Conductor(nombreconductor, numeroconductor);

    /*
    //el carro no esta asoiado al carril, pero el carril si lo está al carro, creamos variables que podemos usar y en la 
    //clase carril los utilizamos; acá se usan de manera abstracta, en la clase carril, se les da un valor real
    //atributos del carril
    int numerocarril;
    int longitudcarril;
    int posicioncarro[];
    */
    
    //metodo para arrojar el dado que dará el avance al carro. OJO, NO ES EL METODO PARA AVANZAR, SOLO ES PARA ARROJAR EL DADO
    /*se podria hacer en la clase principal(juego_carros) pero lo hago acá por que la mecanica de avanzar se da en el carro
    no en la clase principal, en la principal lo que hago es crear un boton que llame este metodo (el siguiente metodo) 
    y lo ejecute*/
    
    /*el metodo simple mente arroja un numero aleatorio de 1 a 6*/
    public int dado(){  //el metodo devuelve un valor de tipo random
        
        int d;
        Random x = new Random();
        d = x.nextInt(6)+1; //x.nextInt convierte el tipo de dato que arroja la funcion random en un entero que se pueda retornar
        
        return d;
    }
    
    
    
    //metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(int idcarro) {
        this.idcarro = idcarro;
    }

    public int getCarril() {
        return Carril;
    }

    public void setCarril(int Carril) {
        this.Carril = Carril;
    }
    
    
}

