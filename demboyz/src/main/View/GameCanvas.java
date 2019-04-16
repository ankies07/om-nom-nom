package View;

import GameModel.Vertex;
import GameModel.entities.*;

import java.awt.*;
import java.security.InvalidParameterException;

public class GameCanvas extends Canvas {

    /*
        This potentially should be a matrix of entities.
     */
    private int[][] gameMatrix;
    // size of every cell in matrix, in pixels
    public final static int CELL_EDGE_SIZE = 20;

    public GameCanvas(int[][] gameMatrix) {
        this.gameMatrix = gameMatrix;
    }

    public void draw() {
        do {
            do {
                drawCanvas();
                drawGameEntities();
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

    private void drawGameEntities() {
        final Graphics2D g2d = (Graphics2D) getDrawGraphics().create();
        for (int y = 0; y < gameMatrix.length; y++) {
            for (int x = 0; x < gameMatrix.length; x++) {
                System.out.print(gameMatrix[x][y]);
                Entity entity = null;
                switch (gameMatrix[y][x]) {
                    case 0:
                        continue;
                    case 1:
                        entity = new Wall(new Vertex(x, y), Color.darkGray);
                        break;
                    case 2:
                        entity = new Food(new Vertex(x, y));
                        break;
                    case 3:
                        entity = new HumanPlayer(new Vertex(x, y));
                        break;
                    case 4:
                        entity = new BotPlayer(new Vertex(x, y));
                        break;
                    default:
                        throw new InvalidParameterException();
                }
                entity.render(g2d);
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
