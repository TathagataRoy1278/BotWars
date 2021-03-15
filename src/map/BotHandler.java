package map;

import java.awt.*;

public class BotHandler {

    private int numberOfDefenders;
    private int numberOfAttackers;
    Color color;

    public BotHandler(int numberOfDefenders, int numberOfAttackers, int color)
    {
            this.numberOfAttackers = numberOfAttackers;
            this.numberOfDefenders = numberOfDefenders;
            this.color = new Color(color*255, 0 , (1-color)*255);
    }

    public void render(Graphics g)
    {

        g.setColor(color);
        for(int i = 0;i<numberOfDefenders;i++)
        {
            int x = (int)(Math.random()*Container.WIDTH);
            int y = (int)(Math.random()*Container.HEIGHT/8);

            g.fillOval(x, y, 30, 30);
        }

        for(int i = 0;i<numberOfAttackers;i++)
        {

            int x = (int)(Math.random()*Container.WIDTH);
            int y = (int)(Math.random()*Container.HEIGHT/8);

            g.fillRect(x, y, 20, 30);

        }

    }
}
