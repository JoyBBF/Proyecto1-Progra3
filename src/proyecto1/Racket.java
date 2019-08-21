/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author nati2
 */
public class Racket extends Actor {
    public int width;
    public int base;
    
    public Racket(int w, int h, int x, int y, int dx, int dy){
        super(x,y,dx,dy);
        this.width=w;
        this.base=h;
    }
    
    @Override
    public void move (Model model){
        x+=dx;
        if(x+width>=model.circ.r+250 || x<=130)
            dx*=-1;
    }
}
