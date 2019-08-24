/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import javax.swing.JFrame;
import java.io.IOException;
import java.util.Observer;
//import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
/**
 *
 * @author nati2
 */
public class View extends JFrame implements Observer{
    public Model model;
    public Controller controller;
    Clip uh;
    
    View(){
        this.setSize(800, 740);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent event){
                formKeyPressed(event);
            }
            public void keyReleased(KeyEvent event){
                formKeyReleased(event);
            }
            
        });
        uh = this.loadSound("media/Bounce.wav");
    }
    
    @Override
    public void update(Observable obs, Object obj){
        this.repaint();
    }
    
    private void formKeyPressed(KeyEvent event){
        switch(event.getKeyCode()){
            case KeyEvent.VK_UP : controller.move(Model.ARR); break;
            case KeyEvent.VK_DOWN : controller.move(Model.ABA); break;
            case KeyEvent.VK_LEFT : controller.move(Model.IZQ); break;
            case KeyEvent.VK_RIGHT : controller.move(Model.DER); break;
        }
    }
    private void formKeyReleased(KeyEvent event){
        int key = event.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT : case KeyEvent.VK_RIGHT : controller.stopHor(); break;
            case KeyEvent.VK_UP : case KeyEvent.VK_DOWN : controller.stopVer(); break;
        }
    }
    
    Clip loadSound(String path){
       try{
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path));
           AudioFormat soundFormat = audioInputStream.getFormat();
           int soundSize = (int)(soundFormat.getFrameSize() * audioInputStream.getFrameLength());
           byte[] soundData=new byte[soundSize];
           DataLine.Info soundInfo= new DataLine.Info(Clip.class, soundFormat, soundSize);
           audioInputStream.read(soundData, 0 , soundSize);
           Clip clip= (Clip) AudioSystem.getLine(soundInfo);
           clip.open(soundFormat, soundData,0, soundSize);
           return clip;
       }
       catch(Exception e){
           return null;
       }
    }
    
    private void jMenuItem2ActionPerformed(ActionEvent event){
        
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
    
    @Override
    public void paint(Graphics graphics){
        super.paintComponents(graphics);
        
        this.renderModel(model, graphics);
    }
    
    public void renderModel(Model m, Graphics graphics){
        renderCirc(m.circ, graphics);
        renderBalls(m.balls, graphics);
        renderRacket(m.rac, graphics);
    }
    
    public void renderCirc(Circle circ, Graphics graphics){
        graphics.setColor(Color.black);
        graphics.drawOval(circ.x, circ.y, circ.r*2, circ.r*2);
    }
    public void renderBalls(Array balls, Graphics graphics){
        Balls actual;
        graphics.setColor(Color.green);
        for(int i=0; i < balls.can; i++){
            actual = balls.getPos(i);
            graphics.fillOval(actual.x-actual.r, actual.y-actual.r, 2*actual.r, 2*actual.r);
            if(balls.getPos(i).w){
                balls.getPos(i).w = false;
                uh.setFramePosition(0);
                uh.start();
            }
        }
    }
    public void renderRacket(Racket racket, Graphics graphics){
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(racket.x, racket.y, racket.base, racket.width);
    }
}
