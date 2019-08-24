/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.event.KeyListener;
import java.util.Observable;
/**
 *
 * @author nati2
 */
public class Model extends Observable {
    public Circle circ;
    public Array balls;
    public Racket rac;
    public final static int ARR = 0;
    public final static int ABA = 1;
    public final static int IZQ = 2;
    public final static int DER = 3;
    

    public Model(int canBalls) {
       circ= new Circle(100,100,300);
       rac=new Racket(30,120,150,500,0,0);
       balls = new Array();
       this.balls.add(new Balls(300,300,25,25,18));
       
    }
    
    public void Steps(){
           balls.move(this);
           rac.move(this);
           this.setChanged();
           this.notifyObservers();
       }
    
    public void start(){
        final int delay = 20;
        Runnable code = new Runnable(){
            public void run(){
                while(true){
                    Steps();
                    setChanged();
                    notifyObservers();
                    try{
                        Thread.sleep(delay);
                    }
                    catch(InterruptedException except){
                    }
                }
            }
        };
        Thread thread = new Thread(code);
        thread.start();
    }
    
    public void move(int flecha){
        switch(flecha){
            case ARR: rac.dy = -20; break;
            case ABA: rac.dy = 20; break;
            case IZQ: rac.dx = -20; break;
            case DER: rac.dx = 20; break;
            
        }
    }
    
    public void stopVer(){
        rac.dy = 0;
    }
    
    public void stopHor(){
        rac.dx = 0;
    }
    
    @Override
    public void addObserver(java.util.Observer obs){
        super.addObserver(obs);
        setChanged();
        notifyObservers();
    }

    public Circle getCirc() {
        return circ;
    }

    public Array getBalls() {
        return balls;
    }

    public Racket getRac() {
        return rac;
    }

    public void setCirc(Circle cir) {
        this.circ = cir;
    }

    public void setBalls(Array balls) {
        this.balls = balls;
    }

    public void setRac(Racket rac) {
        this.rac = rac;
    }
    
    
    
}
