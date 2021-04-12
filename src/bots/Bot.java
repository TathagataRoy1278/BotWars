package bots;

import java.awt.Graphics;

public class Bot {
   int botType;//0 for defender, 1 for attacker
   int velocityX, velocityY;
   int x,y;
   Bullet bullet;
   boolean toFire = false;

   Graphics g;

   public Bot(int x, int y, int botType)
   {
        this.x = x;
        this.y = y;
        this.botType = botType;
   }

   public void setGraphics(Graphics g)
   {
          this.g = g;
   }

   void update()
   {
       x+=velocityX;
       y+=velocityY;

       if(bullet!=null)
       {            
          bullet.update();
          bullet.render();
       }


   }

   void render()
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

        fire(fireDirection, fireStrength, g);
   }

    private void fire(double fireDirection, int fireStrength, Graphics g) {
        bullet = new Bullet(fireStrength, fireDirection, g);

    }

}
