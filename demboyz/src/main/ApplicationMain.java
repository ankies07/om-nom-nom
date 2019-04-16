import GameModel.GameWorld;
import View.GameCanvas;
import View.GameFrame;

import javax.swing.*;

public class ApplicationMain {

    public static void main(String[] args) throws InterruptedException {
        GameWorld maze = new GameWorld(40);
        // create GameEngine, have it contain world + players, make connections between
        GameCanvas canvas = new GameCanvas(maze.getMap());
        GameFrame frame = new GameFrame(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        while (true) {
            frame.draw();
        }
    }
}
