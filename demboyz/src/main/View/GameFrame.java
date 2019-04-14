package View;

import javax.swing.*;

public class GameFrame extends JFrame {

    private GameCanvas canvas;

    public GameFrame(GameCanvas canvas) {
        this.canvas = canvas;
        setResizable(true);
        add(canvas);
        setVisible(true);
    }

    public void draw() {
        canvas.draw();
    }
}
