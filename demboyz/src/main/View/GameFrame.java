package View;

import javax.swing.*;

import static View.GameCanvas.CELL_EDGE_SIZE;

public class GameFrame extends JFrame {

    private GameCanvas canvas;

    public GameFrame(GameCanvas canvas) {
        this.canvas = canvas;
        setSize(canvas.getCanvasSize(), canvas.getCanvasSize() + CELL_EDGE_SIZE);
        setResizable(false);
        add(canvas);
        setVisible(true);
        pack();
    }

    public void draw() {
        canvas.draw();
    }
}
