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

        if(color.getBlue() == 255)
        {
            g.setColor(color);
            defenders[0] = new Bot(Container.WIDTH/2, Container.HEIGHT/8, 0);
            defenders[0].render(g);

            attackers[0] = new Bot(Container.WIDTH/4, Container.HEIGHT/8, 1);
            attackers[0].render(g);
            
            attackers[1] = new Bot(Container.WIDTH*3/4, Container.HEIGHT/8, 1);
            attackers[1].render(g);
        }
        else
        {
            g.setColor(color);
            defenders[0] = new Bot(Container.WIDTH/2, Container.HEIGHT*7/8, 0);
            defenders[0].render(g);

            attackers[0] = new Bot(Container.WIDTH/4, Container.HEIGHT*7/8, 0);
            attackers[0].render(g);
            
            attackers[1] = new Bot(Container.WIDTH*3/4, Container.HEIGHT*7/8, 0);
            attackers[1].render(g);

        }
 
    }


    public void attach() {
        
    }

    public void makeMove(int botType, int botNumber, Move move)
    {
        if(botType==0)
            defenders[botNumber].makeMove(move);


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
