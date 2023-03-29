/**
 Pacman
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pacman extends JFrame implements KeyListener{
    PacmanCanvas canvas;
    PacmanThread thread;
    public Pacman(){
        canvas = new PacmanCanvas(this);
        thread = new PacmanThread(canvas);
        //set up the main container
        setTitle("GOCHUICO, DARELLE BSIT - 2");
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //
        add(canvas);
        setVisible(true);
        addKeyListener(this);
    }

    public void keyReleased(KeyEvent e){}
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_LEFT : 
                canvas.direction = 1;
                break;
            case KeyEvent.VK_RIGHT : 
                canvas.direction = 0;
                break;
            case KeyEvent.VK_UP : 
                canvas.direction = 3;
                break;
            case KeyEvent.VK_DOWN : 
                canvas.direction = 2;
                break;
        }
    }
    public void keyTyped(KeyEvent e){}

    public static void main(String[] args){
        new Pacman();
    }

}// end of class

class PacmanCanvas extends Canvas{//design of the Pacman
    Pacman pacman;
    int x,y,direction;
    int startAngle, endAngle;
    public PacmanCanvas(Pacman pacman){
        this.pacman = pacman;
        startAngle = 30;
        endAngle = 300;
    }

    public void paint(Graphics g){
        //draw or paint your object here
        g.setColor(Color.BLUE);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.YELLOW);
        g.fillArc(x,y,50,50,startAngle,endAngle);
    }
}// end of canvas

class PacmanThread implements Runnable{//Pacman movements
    PacmanCanvas canvas;
    Thread t;
    public PacmanThread(PacmanCanvas canvas){
        this.canvas = canvas;
        t = new Thread(this);
        t.start();
    }

    //let us make the pacman object move horizontally
    public void run(){
        for(;;){
            switch(canvas.direction){
                case 0: //left to right
                    if(canvas.x < canvas.getWidth()-50){
                        if((canvas.x % 9) == 0){
                            canvas.startAngle = 0;
                            canvas.endAngle = 360;
                        } else {
                            canvas.startAngle = 30;
                            canvas.endAngle = 300;
                        }
                        canvas.x+=3;
                    } else canvas.direction = 2;
                    break;
                case 1: //right to left
                    if(canvas.x > 0){
                        canvas.startAngle = 150;
                        canvas.endAngle = -300;
                        canvas.x-=3;
                    } else canvas.direction = 3;
                    break;
                case 2: //up to down
                    if(canvas.y < canvas.getHeight()-50){
                       canvas.startAngle = -60;
                       canvas.endAngle = 300;
                       canvas.y+=3;
                    } else canvas.direction = 1;
                    break;
                case 3: //down to up
                    if(canvas.y > 0){
                       canvas.startAngle = 60;
                       canvas.endAngle = -300;
                       canvas.y-=3;
                    } else canvas.direction = 0;
                    break;

            }
            // repaints the entire canvas
            try{
                t.sleep(25);
                canvas.repaint();
            }catch(Exception e){}
        }
    }
}// end of thread
