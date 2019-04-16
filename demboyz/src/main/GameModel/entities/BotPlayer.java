package GameModel.entities;

import GameModel.Vertex;
import GameModel.Direction;
import java.awt.*;
import java.util.Random;

public class BotPlayer extends Pacman {
    public BotPlayer(Vertex vertex) {
        super(vertex, Color.red);
    }

    public Direction makeMove() {
        int d = this.getRandomNumberInRange(0, 3);
        return Direction.values()[d];
    }

    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
