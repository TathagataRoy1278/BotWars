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
    private boolean running = false;
    private BotHandler redTeam, blueTeam;

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
        redTeam.render(g);
        g.dispose();

    }

    @Override
    public void run() {

        repaint();      
        while(!running)
        {
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    
}