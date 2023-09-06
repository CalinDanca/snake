import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gameframe extends JFrame{
    gameframe(){
        Panel panel = new Panel();
        this.add(panel);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_UP) {
                    panel.Head.setDirection("UP");
                }
                if (key == KeyEvent.VK_DOWN) {
                    panel.Head.setDirection("DOWN");
                }
                if (key == KeyEvent.VK_LEFT){
                    panel.Head.setDirection("LEFT");
                }
                if (key == KeyEvent.VK_RIGHT){
                    panel.Head.setDirection("RIGHT");
                }
            }
            public void keyReleased(KeyEvent e) {
            }
        });

    }
}
