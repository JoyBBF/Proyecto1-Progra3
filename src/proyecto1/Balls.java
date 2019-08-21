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
public class Balls extends Actor{
    public int r;

    public Balls( int x, int y,int r, int dx, int dy) {
        super(x,y,dx,dy);
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
      
    @Override
    public void move(Model model){
        
        float pit=pitagoras(model.circ.x, x+dx, model.circ.y, y+dy);
     
        if(pit >= model.circ.r){
            if(x+dx>=model.circ.x+model.circ.r)
                dx*=-1;
         
            if (y+dy>=model.circ.y+model.circ.r)
                dy*=-1;
        }
        
        
        
        
        if(x+dx>=model.rac.x && x+dx<=model.rac.x+model.rac.width && y+dy>=model.rac.y)
        { setDy(dy*-1);
        }
            
        x+=dx;
        y+=dy;
      
  }
  
  public float pitagoras(int x1, int x2, int y1, int y2){
      return  (float) Math.sqrt((float)Math.pow(x1-x2, 2)+(float)Math.pow(y1-y2, 2));
  } 
}
