import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.Arrays;
import java.util.Random;

public class Panel extends JPanel implements Runnable{
    Thread gamethread;
    public static int width = 400;
    public static int height = 400;
    //index 0 is score for player 1, index 1 is score for player 2
    public static int score = 0;

    SnakePart Head;
    Food food;

    Panel(){
        this.setPreferredSize(new Dimension(width, height));
        Head = new SnakePart("UP" ,width/2, height/2, null, null);
        food = new Food(setFoodXY());
        gamethread = new Thread(this);
        gamethread.start();
    }

// draws the snake and food on the panel
    public void paint(Graphics g){
        Image image = createImage(getWidth(),getHeight());
        Graphics graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    public void draw(Graphics g) {
        Head.draw(g);
        food.draw(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("name",Font.BOLD, 36));
        g.drawString(String.valueOf(score),(int)(width *0.5), 50);

    }
    public void run() {
        long lastTime = System.nanoTime();
        double fpsLimit =4.0;
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
                CheckEaten();
                repaint();
                FrameCounter--;
                if (CheckCollision()) {
                    break;
                }
            }
        }
    }
    //checks if head of snake ate the food
    public void CheckEaten(){
    if(Head.x == food.x && Head.y == food.y){
        Head.addTail();
        food = new Food(setFoodXY());
        score++;
    }
    }

    public boolean CheckCollision(){

        //check if the head of the snake is out of bounds by crashing into the wall
    if(Head.x > width || Head.x < 0){
        return true;
    }
    if(Head.y > height || Head.y < 0){
        return true;
    }
    SnakePart currentPart = Head;

    //checks if the head of the snake collided with any part of its own body
    while(currentPart.behind !=null){
        currentPart = currentPart.behind;
        if(currentPart.x == Head.x && currentPart.y == Head.y){
            return true;
        }
    }

    return false;
    }

    //sets x any y coords of the food for the snake
    public int[] setFoodXY(){
        int x;
        int y;
        //places it somewhere random in the map
        Random rand = new Random();
        boolean InEmptySpot = true;
        do{
           x = rand.nextInt(width/20) * 20;
           y = rand.nextInt(height/20) * 20;
           SnakePart CurrentPart = Head;

           //makes sure the food isnt placed somewhere where the snake is on
           while (true) {
               if (CurrentPart.x == x && CurrentPart.y == y) {
                   InEmptySpot = false;
                   break;
               }
               if (CurrentPart.behind == null){
                   break;
               }
               else{
                   CurrentPart = CurrentPart.behind;
               }
           }
           //returns the coords
       }while(!InEmptySpot);
        return new int[] {x,y};
    }

    public void move(){
    Head.move();
    }
}


