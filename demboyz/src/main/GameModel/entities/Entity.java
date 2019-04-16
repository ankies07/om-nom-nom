package GameModel.entities;

import GameModel.Vertex;
import View.Renderable;

import java.awt.*;

/**
 * Represents all entities on the board, abstract because all entities have in common a position.
 */
public abstract class Entity implements Renderable {

    protected Vertex vertex;
    final Color color;
    final Shape shape;

    public Entity(Vertex vertex, Color color, Shape shape) {
        this.vertex = vertex;
        this.color = color;
        this.shape = shape;
    }

}
