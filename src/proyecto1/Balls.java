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
    public boolean w;

    public Balls( int x, int y,int r, int dx, int dy) {
        super(x,y,dx,dy);
        this.r = r;
        w = false;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
      
    @Override
    public void move(Model model){
        
        float pit=pitagoras(model.circ.x+model.circ.r, x+dx, model.circ.y+model.circ.r, y+dy);
        float pitx1=pitagoras(model.circ.x+model.circ.r, x+dx*-1, model.circ.y+model.circ.r, y+dy);
         //float pitx2=pitagoras(model.circ.x+model.circ.r, x+dx, model.circ.y+model.circ.r, y+dy);
          float pity1=pitagoras(model.circ.x+model.circ.r, x+dx, model.circ.y+model.circ.r, y+dy*-1);
          // float pity2=pitagoras(model.circ.x+model.circ.r, x+dx, model.circ.y+model.circ.r, y+dy);
     
        if(pit >= model.circ.r){
            if(pity1>model.circ.r){
                dx*=-1;
                w = true;
            }
         
            if (pitx1>model.circ.r){
                dy*=-1;
                w = true;
            }
        }
        
        
        
        
        if(x+dx>=model.rac.x && x+dx<=model.rac.x+model.rac.width && y+dy>=model.rac.y)
        { setDy(dy*-1);
           w = true;
        }
            
        x+=dx;
        y+=dy;
      
  }
  
  public float pitagoras(int x1, int x2, int y1, int y2){
      return  (float) Math.sqrt((float)Math.pow(x1-x2, 2)+(float)Math.pow(y1-y2, 2));
  } 
}
