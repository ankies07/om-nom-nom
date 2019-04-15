package GameModel.entities;

import GameModel.Vertex;

import java.awt.*;

public class Wall extends Entity {

    public Wall(Vertex vertex, Color color) {
        super(vertex, color);

    }

    public void render(Graphics2D g) {
        g.setColor(color);
        g.fill(shape);
    }
}
