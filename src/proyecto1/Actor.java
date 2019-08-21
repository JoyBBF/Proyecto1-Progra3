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
public abstract class Actor {
    public int x;
    public int y;
   // protected int r;
    public int dx;
    public int dy;
    
    public Actor(int x, int y, int dx, int dy){
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
    
    public abstract void move (Model model);
    
}
