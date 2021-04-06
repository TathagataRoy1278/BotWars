package bots;

import java.awt.*;
import map.Container;

public class BotHandler implements Runnable{

    private int numberOfDefenders;
    private int numberOfAttackers;
    int[][] attackers, defenders;
    
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

    public Move makeMove()
    {
        return new Move(1,1,1,1);
    }

    @Override
    public void run() {
    }
}
