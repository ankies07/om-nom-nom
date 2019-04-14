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
                drawWalls();
            }
            while (getBufferStrategy().contentsRestored());
            getBufferStrategy().show();
        }
        while (getBufferStrategy().contentsLost());
    }

    private void drawCanvas() {
        Graphics2D g2d = (Graphics2D) getDrawGraphics().create();
        g2d.setColor(Color.lightGray);
        g2d.fillRect(0, 0, gameMatrix.length * CELL_EDGE_SIZE, gameMatrix[0].length * CELL_EDGE_SIZE);
        g2d.dispose();
    }

    private void drawWalls() {
        Graphics2D g2d = (Graphics2D) getDrawGraphics().create();
        g2d.setColor(Color.darkGray);

        for (int y = 0; y < gameMatrix.length; y++) {
            for (int x = 0; x < gameMatrix.length; x++) {
                if (gameMatrix[y][x] == 1) {
                    int drawX = CELL_EDGE_SIZE * x;
                    int drawY = CELL_EDGE_SIZE * y;
                    g2d.fillRect(drawX, drawY, CELL_EDGE_SIZE, CELL_EDGE_SIZE);
                }
            }
        }
        g2d.dispose();
    }

    private Graphics2D getDrawGraphics() {
        if (getBufferStrategy() == null) {
            createBufferStrategy(4);
        }
        return (Graphics2D) getBufferStrategy().getDrawGraphics();
    }

    public int getCanvasSize() {
        return this.gameMatrix.length * CELL_EDGE_SIZE;
    }

}
