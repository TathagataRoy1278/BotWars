package bots;

import java.awt.*;
import map.Container;

public class BotHandler{

    private int numberOfDefenders;
    private int numberOfAttackers;
    Bot[] attackers, defenders;

    int x,y;

    int fireDirection, fireStrength;
    boolean toFire = false;
    Bullet bullet  = null;

    int velocityX = 0, velocityY = 0;

    Color color;
    Graphics g;


    public BotHandler(int numberOfDefenders, int numberOfAttackers, int color)
    {
            this.numberOfAttackers = numberOfAttackers;
            this.numberOfDefenders = numberOfDefenders;
            this.color = new Color(color*255, 0 , (1-color)*255);

            attackers = new Bot[numberOfAttackers];
            defenders = new Bot[numberOfDefenders];


    }

    public void setGraphics(Graphics g)
    {
        this.g = g;
    }


    public void render()
    {

        g.setColor(color);
        for(int i = 0;i<numberOfDefenders;i++)
        {
            defenders[i] = new Bot((int)(Math.random()*Container.WIDTH), (int)(Math.random()*Container.HEIGHT/8), 0);
            defenders[i].render(g);
        }

        for(int i = 0;i<numberOfAttackers;i++)
        {
            attackers[i] = new Bot((int)(Math.random()*Container.WIDTH), (int)(Math.random()*Container.HEIGHT/8), 1);
            attackers[i].render(g);

        }

    }


    public void attach() {

        

    }

    public void makeMove(int botType, int botNumber, Move move)
    {
        velocityX = (int)move.velocityX;
        velocityY = (int)move.velocityY;

        boolean toFire = true;
        double fireDirection = move.fireDirection;
        int fireStrength = (int)move.fireStrength;

    }

    
    public void update() {
        x += velocityX;
        y += velocityY;

        if(toFire)
        {
            fire(fireDirection, fireStrength);
            toFire = false;
        }

        if(bullet!=null)
            bullet.update();


    }

    private void fire(double fireDirection, int fireStrength) {
        Bullet bullet = new Bullet(fireStrength, fireDirection, g);

    }

    class Bullet
    {
        int x,y;
        int size = 10;
        double velocityX, velocityY;
        Graphics g;

        public Bullet(int fireStrength, double fireDirection, Graphics g)
        {
            this.g = g;
        }

        void render()
        {
            g.setColor(Color.BLACK);
            g.drawOval(x, y, size, size);
        }


        public void update() {

            g.setColor(Container.bgColor);
            g.drawOval(x, y, size, size);

            x += velocityX;
            y += velocityY;
        }

    }
}
