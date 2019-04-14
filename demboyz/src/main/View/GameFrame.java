package View;

import javax.swing.*;

public class GameFrame extends JFrame {

    private GameCanvas canvas;

    public GameFrame(GameCanvas canvas) {
        this.canvas = canvas;
        setSize(canvas.getCanvasSize(), canvas.getCanvasSize());
        setResizable(false);
        add(canvas);
        setVisible(true);
        pack();
    }

    public void draw() {
        canvas.draw();
    }
}
