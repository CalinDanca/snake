import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Food {
    int x;
    int y;

    Food(int[] a){
        this.x = a[0];
        this.y = a[1];
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x,y,20,20);
    }

}
