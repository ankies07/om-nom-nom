package GameModel.entities;

import GameModel.Vertex;

import java.awt.*;

import static View.GameCanvas.CELL_EDGE_SIZE;

public class Wall extends Entity {

    public Wall(Vertex vertex, Color color) {
        super(vertex, color, new Rectangle(
                vertex.getX() * CELL_EDGE_SIZE,
                vertex.getY() * CELL_EDGE_SIZE,
                CELL_EDGE_SIZE,
                CELL_EDGE_SIZE)
        );

    }

    public void render(Graphics2D g) {
        g.setColor(color);
        g.fill(shape);
    }
}
