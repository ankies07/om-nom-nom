package GameModel.entities;

import GameModel.Direction;
import GameModel.Vertex;

import java.awt.*;
import java.util.Scanner;

public class HumanPlayer extends Pacman {

    public HumanPlayer(Vertex vertex) {
        super(vertex, Color.yellow);
    }

    public Direction makeMove() {
        Direction move = null;
        boolean validKey = false;
        Scanner in = new Scanner(System.in);
        while (!validKey) {
            String keyPressed = in.next();
            if (keyPressed.length() == 1) {
                keyPressed = keyPressed.toLowerCase();
                switch (keyPressed) {
                    case "w":
                        move = Direction.UP;
                        break;
                    case "s":
                        move = Direction.DOWN;
                        break;
                    case "a":
                        move = Direction.LEFT;
                        break;
                    case "d":
                        move = Direction.RIGHT;
                        break;
                    default:
                        break;
                }
                validKey = move != null;
            }
        }
        return move;
    }
}
