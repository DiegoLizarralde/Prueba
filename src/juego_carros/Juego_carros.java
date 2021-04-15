/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package juego_carros;

//librerias importadas

import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class Juego_carros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        //crear pista
        String nombre = JOptionPane.showInputDialog("ingresa el nombre de la pista");//objpista
        int carriles = Integer.parseInt(JOptionPane.showInputDialog("ingresa el numero de carriles"));//objpista
        int limDistancia = Integer.parseInt(JOptionPane.showInputDialog("ingresa el limite de distancia en kilometros"));//objpista
        
        Pista objpista = new Pista(nombre, carriles, limDistancia);
        
        //crear carril 1, 2, 3, etc...
        //preguntar datos a los jugadores
        //int i = 0;//itera el ciclo
        //int[ ] A= new  int[carriles];//arreglo 
        int j=0;
        
                
        //arreglo para carril
        Carril objcarril[] = new Carril[objpista.carriles];
        
        //int numerodecarril = 0;//Integer.parseInt(JOptionPane.showInputDialog("ingresa el numero de su carril"));//objcarril
        //int longitud = limDistancia;//objcarril
        //int posicioncarro = 0;//objcarril
        
        
                
        //arreglo para carro
        Carro objcarro[] = new Carro[objpista.carriles];
        
        //String nombrecarro = JOptionPane.showInputDialog("ingresa nombre del carro") ;//objcarro
        //String marca = JOptionPane.showInputDialog("ingresa la marca del carro") ;//objcarro
        //String color = JOptionPane.showInputDialog("ingresa el color del carro");//objcarro
        //int idcarro = numerodecarril;//Integer.parseInt(JOptionPane.showInputDialog("ingresa el numero del carro"));//objcarro
        //int numcarril = numerodecarril;//objcarro-será igual al numero de carril de objcarril
        
        
        
        
        //arreglo para conductor
        Conductor objconductor[] = new Conductor[objpista.carriles];
        
        //String nombrejugador = JOptionPane.showInputDialog("ingresa nombre del jugador");//objconductor
        //int num = numerodecarril;//Integer.parseInt(JOptionPane.showInputDialog("ingresa el numero del jugador"));//objconductor


        
        
        //ciclo para registrar los corredores en los arreglos de objetos
        //do
        for(int i = 0; i <= objpista.carriles; i ++)
        {
            //objcarril[i].longitud =
            
            objcarro[i].nombre = JOptionPane.showInputDialog("ingresa nombre del carro") ;//nombrecarro objcarro
            objcarro[i].marca = JOptionPane.showInputDialog("ingresa la marca del carro") ;//marca objcarro
            objcarro[i].color = JOptionPane.showInputDialog("ingresa el color del carro");//color objcarro
            objcarro[i].idcarro = Integer.parseInt(JOptionPane.showInputDialog("ingresa el numero del carro"));//idcarroobjcarro
            objcarro[i].Carril = i;//numcarril objcarro
            objconductor[i].nombre =  JOptionPane.showInputDialog("ingresa nombre del jugador aquí: ");//nombrejugador objconductor
            objconductor[i].num =  i ;//objconductor
            objcarril[i].numerodecarril =  i ;//objcarril
            objcarril[i].longitud = limDistancia; //longitud objcarril
            objcarril[i].posicioncarro =  0 ;//objcarril
            
            
            
        }//while( i <= carriles);
        
        
        
        //ciclo para jugar,crear boton jugar para cada jugador, hasta que se termine el recorrido en todos los jugadores
        int d=1;
        int c = 0;
        
        //int intentos = 0;------------------------
        //while(j<=longitud) //j sea menor que la longitud de la pista
        //{
            while(c <= objcarro.length)//i menor que la cantidad de carros
            //pedirle a cada conductor que arroje el dado -----objconductor[j].nombre = "";
            {
                JOptionPane.showMessageDialog(null, objconductor[c].nombre + ", arroja el dado");
                d = objcarro[c].dado();
                JOptionPane.showMessageDialog(null, "el dado nos arrojó un " + d);
                objcarril[c].avance(d);
                //objcarril[j].posicion(d); --- actualiza la posicion del carro en el carril
                JOptionPane.showMessageDialog(null, "su nueva posición es " + objcarril[c].posicion(d));
                /*if(objcarril[c].posicioncarro)
                {
                    
                }*/
                //ubico en el podio
                c++;
            }
            
            
            
            //j++;
        //}
        
    }
    
}
