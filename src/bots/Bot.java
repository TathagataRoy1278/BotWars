package bots;

import java.awt.Graphics;

public class Bot {
   int botType;//0 for defender, 1 for attacker
   int velocityX, velocityY;
   int x,y;

   public Bot(int x, int y, int botType)
   {
        this.x = x;
        this.y = y;
        this.botType = botType;
   }


   void update()
   {
       x+=velocityX;
       y+=velocityY;
   }

   void render(Graphics g)
   {
       if(botType==1)
        g.fillOval(x, y, 30, 30);
       else
        g.fillRect(x, y, 20, 30);
   }

   void makeMove(Move move)
   {
        velocityX = (int)move.velocityX;
        velocityY = (int)move.velocityY;

        boolean toFire = true;
        double fireDirection = move.fireDirection;
        int fireStrength = (int)move.fireStrength;
   }

}
