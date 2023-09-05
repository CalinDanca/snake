import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.Arrays;

public class Panel extends JPanel implements Runnable{
    Thread gamethread;
    public static int width = 1000;
    public static int height = 1000;
    //index 0 is score for player 1, index 1 is score for player 2
    public static int[] score = {0,0};
   // Paddle Player1;
  //  Paddle Player2;
    SnakePart Head;
   // ball new_ball;
    Panel(){

        this.setPreferredSize(new Dimension(width, height));
        Head = new SnakePart("UP", 0, 0, null, null);
      //  Player1 = new Paddle(1, 20, height);
     //   Player2 = new Paddle(2, width-40, height);
     //   new_ball =new ball((int)(width * 0.5), (int)(height*0.5));
        gamethread = new Thread(this);
        gamethread.start();
    }


    public void paint(Graphics g){
        Image image = createImage(getWidth(),getHeight());

        Graphics graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    public void draw(Graphics g) {
      //  Player1.draw(g);
      //   Player2.draw(g);
      //  new_ball.draw(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("name",Font.BOLD, 36));
        g.drawLine((int)(width*0.5), 0, (int)(width*0.5), height);
        g.drawString(String.valueOf(score[0]),(int)(width *0.5 - 50), 50);
        g.drawString(String.valueOf(score[1]),(int)(width *0.5 + 30), 50);
    }
    public void run() {
        long lastTime = System.nanoTime();
        double fpsLimit =60.0;
        //nanoseconds in each frame
        //60 frames as most monitors 60hz
        double nsPerFrame = 1000000000.0 / fpsLimit;
        double FrameCounter = 0;
        while(true){
            long NewTime = System.nanoTime();
            FrameCounter += (NewTime -lastTime)/nsPerFrame;
            lastTime = NewTime;
            if(FrameCounter >=1) {
                move();
                CheckCollision();
                repaint();
                FrameCounter--;
                if (score[0] == 10 || score[1] == 10) {
                    break;
                }
            }
        }
    }
    public void CheckCollision(){

    }

    public void move(){

    }
}


