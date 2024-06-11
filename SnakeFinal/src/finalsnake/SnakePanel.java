package finalsnake;

import java.awt.Color;
import java.io.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakePanel extends JPanel implements ActionListener {
  
    int size = 20, grid = 1200;
    int snake_length, cherry_x, cherry_y;
    int x[] = new int[grid];
    int y[] = new int[grid];
    boolean left = false, right = true, up = false, down = false, playing = true;
    String[] game = {"Game Over", "Koniec Gry", "SCORE", "WYNIK"};
    int i = 0;
    int j = 2;
    static int score;

    Timer timer;
    Image body, cherry, head;  
    ImageIcon body_icn, head_icn, cherry_icn;

    public SnakePanel(int delay) {
    	addKeyListener(new TAdapter());
        setBackground(new Color(27,55,35));
        setFocusable(true);
        setPreferredSize(new Dimension(800, 600));
        
        snake_length = 3;
        for (int i = 0; i < snake_length; i++) {
            x[i] = 100 - i * 20;
            y[i] = 100;
        }
        timer = new Timer(delay, this);
        timer.start();
        
        body_icn = new ImageIcon("src/snake_files/body.png");
        body = body_icn.getImage();
        cherry_icn = new ImageIcon("src/snake_files/cherry.png");
        cherry = cherry_icn.getImage();
        head_icn = new ImageIcon("src/snake_files/head.png");
        head = head_icn.getImage();
        placeCherry();
        if(MainMenu.i==1) {
        	i = 1; j = 3;
        }
        else {
        	i = 0; j = 2;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (playing) {
            g.drawImage(cherry, cherry_x, cherry_y, this);
            for (int i = 0; i < snake_length; i++) {
                if (i == 0) {
                    g.drawImage(head, x[i], y[i], this);
                } else {
                    g.drawImage(body, x[i], y[i], this);
                }
            }
        } 
        else {
        	g.setColor(Color.white);
            g.setFont(new Font("Garamond", Font.BOLD, 60));
            g.drawString(game[i], 240, 250);
        	score = snake_length - 3;
        	g.setFont(new Font("Garamond", Font.BOLD, 40));
        	g.drawString(String.format(game[j]+": %d", score), 300, 350);
        	if(score > MainMenu.wynik) {
        		MainMenu.topScore.setText(String.format("TOP:  %d", score));
        		MainMenu.wynik = score;
        	}
        } 
    }
    
    private void move() {
        for (int i = snake_length; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if (left) {
            x[0] -= size;
        }
        if (right) {
            x[0] += size;
        }
        if (up) {
            y[0] -= size;
        }
        if (down) {
            y[0] += size;
        }
    }
    
    private void cherryCollision() {
        if ((x[0] == cherry_x) && (y[0] == cherry_y)) {
        	snake_length++;
        	placeCherry();
        }
    }

    private void snakeCollision() {
        for (int i = snake_length; i > 0; i--) {
            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
            	playing = false;
            }
        }
        if (y[0] >= 600) {
        	playing = false;
        }
        if (y[0] < 0) {
        	playing = false;
        }
        if (x[0] >= 800) {
        	playing = false;
        }
        if (x[0] < 0) {
        	playing = false;
        }    
        if (!playing) {
            timer.stop();
        }
    }

    private void placeCherry() {
        int rand = (int) (Math.random() * 39);
        cherry_x = ((rand * size));
        rand = (int) (Math.random() * 29);
        cherry_y = ((rand * size));
    }

    public void actionPerformed(ActionEvent e) {
        if (playing) {
        	cherryCollision();
            snakeCollision();
            move();
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT) && (!right)) {
                left = true;
                up = false;
                down = false;
            }
            if ((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT) && (!left)) {
                right = true;
                up = false;
                down = false;
            }
            if ((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP) && (!down)) {
                up = true;
                right = false;
                left = false;
            }
            if ((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN) && (!up)) {
                down = true;
                right = false;
                left = false;
            }
        }
    }
}
