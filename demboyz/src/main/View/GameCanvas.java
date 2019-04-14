package View;

import java.awt.*;

public class GameCanvas extends Canvas {

    private int[][] gameMatrix;
    // size of every cell in matrix, in pixels
    private final static int CELL_EDGE_SIZE = 20;

    public GameCanvas(int[][] gameMatrix) {
        this.gameMatrix = gameMatrix;
    }


    public void draw() {
        do {
            do {
                drawCanvas();
            }
            while (getBufferStrategy().contentsRestored());
            getBufferStrategy().show();
        }
        while (getBufferStrategy().contentsLost());
    }

    private void drawCanvas() {
        Graphics2D g2d = getDrawGraphics();
        g2d.setColor(Color.darkGray);
        g2d.fillRect(0, 0, gameMatrix.length * CELL_EDGE_SIZE, gameMatrix[0].length * CELL_EDGE_SIZE);
        g2d.dispose();
    }

    private Graphics2D getDrawGraphics() {
        if (getBufferStrategy() == null) {
            createBufferStrategy(4);
        }
        return (Graphics2D) getBufferStrategy().getDrawGraphics();
    }

}
