package bots;

import java.util.Arrays;

public class BotInfo {
    private int blueAttackers[][], blueDefenders[][];
    private int redAttackers[][], redDefenders[][];


    
    public int[][] getRedAttackers()
    {
        return Arrays.copyOf(redAttackers, redAttackers.length);
    }

    public int[][] getRedDefenders()
    {
        return Arrays.copyOf(redDefenders, redDefenders.length);
    }

    public int[][] getBlueAttackers()
    {
        return Arrays.copyOf(blueAttackers, blueAttackers.length);
    }

    public int[][] getBlueDefenders()
    {
        return Arrays.copyOf(blueDefenders, blueDefenders.length);
    }



}
