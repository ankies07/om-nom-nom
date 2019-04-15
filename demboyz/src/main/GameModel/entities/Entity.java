package GameModel.entities;

import GameModel.Vertex;
import View.Renderable;

import java.awt.*;

import static View.GameCanvas.CELL_EDGE_SIZE;

/**
 * Represents all entities on the board, abstract because all entities have in common a position.
 */
public abstract class Entity implements Renderable {

    final Vertex vertex;
    final Color color;
    final Shape shape;

    public Entity(Vertex vertex, Color color) {
        this.vertex = vertex;
        this.color = color;
        this.shape = new Rectangle(
                vertex.getX() * CELL_EDGE_SIZE, vertex.getY() * CELL_EDGE_SIZE, CELL_EDGE_SIZE, CELL_EDGE_SIZE
        );
    }
}
