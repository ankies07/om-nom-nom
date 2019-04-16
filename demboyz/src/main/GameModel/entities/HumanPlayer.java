package GameModel.entities;

import GameModel.Vertex;
import GameModel.Direction;
import java.awt.*;
import java.awt.event.KeyEvent;

public class HumanPlayer extends Pacman {
    public HumanPlayer(Vertex vertex) {
        super(vertex, Color.yellow);
    }

    public Direction makeMove(KeyEvent e) {
        Direction move;
        int key = e.getKeyCode ();
        switch (key) {
            case KeyEvent.VK_UP:
                move = Direction.UP;
            case KeyEvent.VK_DOWN:
                move = Direction.DOWN;
            case KeyEvent.VK_LEFT:
                move = Direction.LEFT;
            default:
                move = Direction.RIGHT;
        }
        return move;
    }
}
