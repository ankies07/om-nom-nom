import View.GameCanvas;
import View.GameFrame;
import GameModel.GameWorld;

import javax.swing.*;

public class ApplicationMain {

    public static void main(String[] args) throws InterruptedException {
        GameWorld maze = new GameWorld(40);
        GameCanvas canvas = new GameCanvas(maze.getMap());
        GameFrame frame = new GameFrame(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        while(true) {
            frame.draw();
            Thread.sleep(100);
        }
    }
}
