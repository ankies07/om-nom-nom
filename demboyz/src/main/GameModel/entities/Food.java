package GameModel.entities;

import GameModel.Vertex;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import static View.GameCanvas.CELL_EDGE_SIZE;

public class Food extends Entity{
    public Food(Vertex vertex) {
        super(vertex, Color.green, new Ellipse2D.Double(
                (double) vertex.getX() * CELL_EDGE_SIZE + CELL_EDGE_SIZE / 4,
                (double) vertex.getY() * CELL_EDGE_SIZE + CELL_EDGE_SIZE / 4,
                (double) CELL_EDGE_SIZE/2,
                (double) CELL_EDGE_SIZE/2
        ));
    }

    public void render(Graphics2D g) {
        g.setColor(color);
        g.fill(shape);
    }
}
