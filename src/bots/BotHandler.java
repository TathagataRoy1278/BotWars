package bots;

import java.awt.*;
import map.Container;

public class BotHandler{

    private int numberOfDefenders;
    private int numberOfAttackers;
    int[][] attackers, defenders;

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

            attackers = new int[numberOfAttackers][2];
            defenders = new int[numberOfDefenders][2];


    }

    public void setGraphics(Graphics g)
    {
        this.g = g;
    }


    public void init()
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

            g.setColor(Container.bgcolor);
            g.drawOval(x, y, size, size);

            x += velocityX;
            y += velocityY;
        }

    }
}
