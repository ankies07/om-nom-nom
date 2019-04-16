package GameModel.entities;

import GameModel.Vertex;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import static View.GameCanvas.CELL_EDGE_SIZE;

public class Pacman extends Entity {
    public Pacman(Vertex vertex, Color color) {

        super(vertex, color, new Ellipse2D.Double(
                        (double) vertex.getX() * CELL_EDGE_SIZE,
                        (double) vertex.getY() * CELL_EDGE_SIZE,
                        (double) CELL_EDGE_SIZE,
                        (double) CELL_EDGE_SIZE
                )
        );
    }

    public void render(Graphics2D g) {
        g.setColor(color);
        g.fill(shape);
    }

}
