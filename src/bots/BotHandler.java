package bots;

import java.awt.*;
import map.Container;

public class BotHandler implements Runnable{

    private int numberOfDefenders;
    private int numberOfAttackers;
    int[][] attackers, defenders;

    int x,y;

    int fireDirection, fireStrength;
    boolean toFire = false;


    int velocityX = 0, velocityY = 0;
    Color color;

    public BotHandler(int numberOfDefenders, int numberOfAttackers, int color)
    {
            this.numberOfAttackers = numberOfAttackers;
            this.numberOfDefenders = numberOfDefenders;
            this.color = new Color(color*255, 0 , (1-color)*255);

            attackers = new int[numberOfAttackers][2];
            defenders = new int[numberOfDefenders][2];

    }

    public void render(Graphics g)
    {

        g.setColor(color);
        for(int i = 0;i<numberOfDefenders;i++)
        {
            defenders[i][0] = (int)(Math.random()*Container.WIDTH);
            defenders[i][1] = (int)(Math.random()*Container.HEIGHT/8);

            g.fillOval(defenders[i][0], defenders[i][1], 30, 30);
        }

        for(int i = 0;i<numberOfAttackers;i++)
        {

            attackers[i][0] = (int)(Math.random()*Container.WIDTH);
            attackers[i][1] = (int)(Math.random()*Container.HEIGHT/8);

            g.fillRect(attackers[i][0], attackers[i][1], 20, 30);

        }

    }

    public void attach() {

        

    }

    public void makeMove(Move move)
    {
        velocityX = (int)move.velocityX;
        velocityY = (int)move.velocityY;

        int toFire = true;
        int fireDirection = (int)move.fireDirection;
        int fireStrength = (int)move.fireStrength;

    }

    @Override
    public void run() {
        x += velocityX;
        y += velocityY;

        if(toFire)
        {
            fire(fireDirection, fireStrength);
            toFire = false;
        }
    }

    private void fire(int fireDirection, int fireStrength) {

        

    }

    class Bullet implements Runnable
    {
        int x,y;
        double velocityX, velocityY;


        void render(Graphics g)
        {
            g.drawOval(x, y, 10, 10);
        }


        @Override
        public void run() {
            x += velocityX;
            y += velocityY;
        }

    }
}
