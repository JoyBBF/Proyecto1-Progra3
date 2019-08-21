/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

 
public class main {
    
    public static void main(String[] args) throws InterruptedException{
        Model model = new Model(1);
        View view = new View();
        Controller controller = new Controller(model, view);
        
        view.setVisible(true);
        
        
        while(true){
            Thread.sleep(1000);
            model.Steps();
            //break;
        }
    }
    
    //Juego p1=new Juego();
    //pj.jugar();
    //return 0;
    //System.out.printl("Hola mundo");
}
