package views;

import config.Config;
import views.panels.GamePanel;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Window extends JFrame {

    public Window() {
        super("LEMMINGS GAME");
        this.setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        this.setLocation(50, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new GamePanel());

        this.setResizable(false);
        this.setVisible(true);
        setEnabled(true);
    }

    @Override
    public void repaint() {
        super.repaint();
        Arrays.stream(this.getComponents()).forEach(Component::repaint);
    }
}
