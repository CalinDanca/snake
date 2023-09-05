import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class SnakePart {
String direction;
int x;
int y;

SnakePart infront;
SnakePart behind;

    SnakePart(String direction, int x, int y, SnakePart infront, SnakePart behind){

        this.direction = direction;
        this.x = x;
        this.y = y;
        this.infront = infront;
        this.behind = behind;
    }
    public void setDirection(String direction){
        if(this.behind !=null){
            this.behind.setDirection(this.direction);
        }
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

    }


    }

