import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class SnakePart {
String direction;
int x;
int y;
int old_x;
int old_y;

SnakePart infront;
SnakePart behind;

    SnakePart(String direction, int x, int y, SnakePart infront, SnakePart behind){

        this.direction = direction;

        this.x = x;
        this.y = y;
        this.old_x = x;
        this.old_y = y;
        this.infront = infront;
        this.behind = behind;
    }
    public void addTail(){
    SnakePart oldTail = this;
    while(oldTail.behind != null){
        oldTail = oldTail.behind;
    }
    oldTail.behind = new SnakePart(null, oldTail.old_x, oldTail.old_y, oldTail, null);
    }
    public void setDirection(String direction){
        this.direction = direction;
    }
    public void draw(Graphics g) {
        if(this.behind !=null){
            this.behind.draw(g);
        }
        g.setColor(Color.green);
        g.fillRect(x, y, 20,20);
    }

    public void move(){
    if(direction != null){
        //moves the head in its direction and saves its old coordinates
        switch (direction) {
            case "UP" -> {
                old_y = y;
                old_x = x;
                y = y - 20;
            }
            case "DOWN" -> {
                old_y = y;
                old_x = x;
                y = y + 20;
            }
            case "LEFT" -> {
                old_x = x;
                old_y = y;
                x = x - 20;
            }
            case "RIGHT" -> {
                old_x = x;
                old_y = y;
                x = x + 20;
            }
        }
    }

    SnakePart Current = this;
    //saves snake part behind previous's x and y. then replaces them with the old x and y of the body part in front.
    while(Current.behind !=null){
        Current.behind.old_x = Current.behind.x;
        Current.behind.old_y = Current.behind.y;
        Current.behind.x = Current.old_x;
        Current.behind.y = Current.old_y;
        Current = Current.behind;
    }
    }



    }

