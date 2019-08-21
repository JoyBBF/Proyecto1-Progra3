/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;
//import java.io.FileNotFoundException;
/**
 *
 * @author nati2
 */
public class Array {
    Balls[] array;
    int tam;
    int can;

    public Array() {
        int tam=10;
        int can=0;
        for (int i=0; i<tam;i++){
            array[i]=null;
        }
    }
    
    public void add(Balls ball){
        if(can<tam)
        {
            array[can]=ball;
            can++;
        }
        /*else {
            throw ;
        }*/
        //Implementar las excepciones
    }
    
    public void remove(){
        if (can>0){
            array[can]=null;
            can--;
        }
        //else->exception implementar
    }

    public int getCan() {
        return can;
    }
    
    public Balls getPos(int i){
        if (i<can && i>=0)
        {
           return array[i]; 
        }
        //else->exception implementar
        return null;///me obligó a poner esto por mientras, ahí lo corriges
    }
    
    public void move(int i, Model model){
        if (i<can && i>=0)
        {
           array[i].move(model);
        }
        //else->exception implementar
    }
}
