/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import javax.swing.JFrame;
import java.io.IOException;
import java.util.Observer;
//import java.io.InputStream;
import javax.imageio.ImageIO;
/**
 *
 * @author nati2
 */
public class View extends JFrame implements Observer{
    public Model model;
    public Controller controller;
    
    View(){
        this.setSize(800, 740);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    @Override
    public void update(Observable obs, Object obj){
        this.repaint();
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public void paint(Model model, Graphics graphics){
        super.paintComponents(graphics);
        
        this.renderModel(model, graphics);
    }
    
    public void renderModel(Model m, Graphics g){
        renderCirc(m.circ, g);
        renderBalls(m.balls, g);
        renderRacket(m.rac, g);
    }
    
    public void renderCirc(Circle circ, Graphics graphics){
        graphics.setColor(Color.black);
        graphics.drawOval(circ.x, circ.y, circ.r*2, circ.r*2);
    }
    public void renderBalls(Array balls, Graphics graphics){
        Balls actual;
        for(int i=0; i<balls.can;i++){
            actual = balls.getPos(i);
            graphics.setColor(Color.green);
            graphics.fillOval(actual.x-actual.r, actual.y-actual.r, 2*actual.r, 2*actual.r);
        }
    }
    public void renderRacket(Racket racket, Graphics graphics){
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(racket.x, racket.y, racket.base, racket.width);
    }
}
