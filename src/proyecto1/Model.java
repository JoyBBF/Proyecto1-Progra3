/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.util.Observable;
/**
 *
 * @author nati2
 */
public class Model extends Observable {
    public Circle circ;
    public Array balls;
    public Racket rac;

    public Model(int canBalls) {
       circ= new Circle(750,750,900 );
       rac=new Racket(150,30,0,600,80,0);
       balls = new Array();
       balls.add(new Balls(200,150,25,40,30)); 
    }
    
    public void Steps(){
           for (int i=0;i<balls.getCan();i++)
               balls.move(i, this);
           rac.move(this);
           this.setChanged();
           this.notifyObservers();
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
