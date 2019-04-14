import View.GameCanvas;
import View.GameFrame;

import javax.swing.*;

public class ApplicationMain {

    public static void main(String[] args) {

        int[][] matrix = new int[25][25];
        GameCanvas canvas = new GameCanvas(matrix);
        GameFrame frame = new GameFrame(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        while(true) {
            frame.draw();
        }
    }
}
