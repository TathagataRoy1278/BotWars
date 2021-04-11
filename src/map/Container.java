package map;

import java.util.*;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import bots.*;

public class Container extends Canvas implements Runnable
{


    private JFrame frame;
    public static final int WIDTH = 600, HEIGHT = 800;
    private Thread mainLoop;
    private static boolean running = false;
    private BotHandler redTeam, blueTeam;

    Graphics g;

    final public static Color bgColor = Color.WHITE;

    public Container()
    {
        frame = new JFrame();

        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        redTeam = new BotHandler(2, 1, 1);

        running = true;
        mainLoop = new Thread(this);
        mainLoop.start();

    }

    public void paint(Graphics g)
    {
        this.g = g;
        redTeam.setGraphics(g);
        redTeam.render();

    }

    private void update()
    {
        redTeam.update();
    }

    private void render()
    {
        redTeam.render();

        removeAllComponents();
    }

    private void removeAllComponents() {
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    @Override
    public void run() {
        final short frameRate = 10;
      
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000 / frameRate;
        
        double delta = 0;
        int frames = 0;
        
          
        while(running)
        {
          
          long now = System.nanoTime();
          delta += (now-lastTime)/ns;
    
          lastTime = now;
          while(delta >= 1)
          {
            update();
            render();
              delta--;
          }
          
          //render();
          frames++;
    
          if(System.currentTimeMillis()-timer > 1000){
              timer+=1000;
              this.frame.setTitle("CTF" + " " +  frames + "fps");
              frames = 0;
          }
    
        }
    
        stop();
    
    }

    private void stop()
    {
        g.dispose();
        running = false;
    }

    public static boolean isRunning() {
        return running;
    }
    
}