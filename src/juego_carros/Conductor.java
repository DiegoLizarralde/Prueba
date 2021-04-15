/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_carros;

/**
 *
 * @author User
 */
public class Conductor {
    //carro asociado
    String nombre;
    int num;

    public Conductor(String nombre, int num) {
        this.nombre = nombre;
        this.num = num;
    }
    
    
    //este no lo asocio a nunguna clase, por que ya cree el objeto tipo conductor en la clase carro, ya que se asocian allí.

    
    //metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    
    
}
